package com.proyectofinal.web.service;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.proyectofinal.web.dao.ImageDao;
import com.proyectofinal.web.dao.MemberDao;
import com.proyectofinal.web.dao.ProjectDao;
import com.proyectofinal.web.dao.RequirementDao;
import com.proyectofinal.web.dao.SRSDao;
import com.proyectofinal.web.dao.SpecificationDao;
import com.proyectofinal.web.dao.UserDao;
import com.proyectofinal.web.model.Member;
import com.proyectofinal.web.model.Project;
import com.proyectofinal.web.model.ProjectCreate;
import com.proyectofinal.web.model.Requirement;
import com.proyectofinal.web.model.SRS;
import com.proyectofinal.web.model.SRSEditDescrGlobal;
import com.proyectofinal.web.model.SRSEditIntro;
import com.proyectofinal.web.model.SRSEditReqs;
import com.proyectofinal.web.model.Specification;
import com.proyectofinal.web.model.User;
/**
 * Project:Sigere
 * Developer:Laura Arango,Verónica Tofiño.
 * Contact email:lauarangom@gmail.com, veronicatofino@gmail.com
 * Creation date: 02/06/2019
 * Last modification: 03/06/2019
 */
public class SRSServiceImpl implements SRSService {
	@Autowired
	SRSDao srsDao;
	@Autowired
	MemberDao memberDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ProjectDao projectDao;
	@Autowired
	RequirementDao requirementDao;
	@Autowired
	SpecificationDao specificationDao;
	@Autowired
	ImageDao imageDao;
	//Create the SRS of the project
	@Override
	public void createSRS(ProjectCreate project) {
		srsDao.createSRS(project);
	}
	//Edit the introduction of the SRS of the project
	@Override
	public void editSRSIntro(SRSEditIntro srs, String version) {
		srsDao.editSRSIntro(srs,version);	
	}
	//Edit the global description of SRS of the project
	@Override
	public void editSRSDescrGlobal(SRSEditDescrGlobal srs, String version) {
		srsDao.editSRSDescrGlobal(srs,version);
	}
	//Edit the Other requirements of SRS of the project
	@Override
	public void editSRSReqs(SRSEditReqs srs, String version) {
		srsDao.editSRSReqs(srs,version);
		
	}
	//Returns the SRS of a project
	@Override
	public SRS getSRSByProjectId(int id) {
		return srsDao.getSRSByProjectId(id);
	}
	//Generates the PDF SRS.
	@Override
	public void generateSRS(int projectId) throws DocumentException, IOException {
		final Font titleBold= new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
		final Font header1= new Font(Font.FontFamily.TIMES_ROMAN, 16);
		header1.setColor(41, 82, 163);
		final Font header2= new Font(Font.FontFamily.TIMES_ROMAN, 13);
		header2.setColor(132, 163, 225);
		final Font header3= new Font(Font.FontFamily.TIMES_ROMAN, 12);
		header3.setColor(30, 61, 123);
		final Font textP= new Font(Font.FontFamily.TIMES_ROMAN, 12);
		final Font textPB= new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
		List <Member> members = memberDao.getUsersByProjectId(projectId);
		final Project project =projectDao.getProjectById(projectId);
		final SRS srs = srsDao.getSRSByProjectId(projectId);
		Document document = new Document(PageSize.A4,64,64,64,64);
		PdfWriter.getInstance(document, new FileOutputStream(System.getProperty("user.home")+"/Desktop/SRS "+project.getName()+" version "+srs.getVersion()+".pdf"));
		final StringBuilder memberBuilder = new StringBuilder();
		for (Member m : members) {
			final User user = userDao.getUserById(m.getUserId());
			memberBuilder.append(user.getFirstname()+" "+user.getLastname()+ ",");
		}
		String usersF = memberBuilder.toString();
	    document.addAuthor(usersF);
	    document.addCreationDate();
	    document.addCreator("SIGERE.com");
	    document.addTitle("SRS");
	    document.addSubject("Documento final creado para el proyecto.");
		document.open();
		addTitlePage(document, titleBold, projectId);
		addContentTable(document,titleBold,projectId);
		document.newPage();
        addIntroduction(document,header1,header2,textP,projectId);	
        document.newPage();
        addGlobalDescription(document, header1, header2, header3, textP, projectId);
        document.newPage();
        addRequirements(document, header1,header2,header3,textP,textPB,projectId);
		document.newPage();
		addImages(document,header1,header2,textP,projectId);
        document.close();
		
		
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
	private void addTitlePage(Document document, Font titleBold, int projectId)
	            throws DocumentException {
		final Project project = projectDao.getProjectById(projectId);
		final SRS srs = srsDao.getSRSByProjectId(projectId);
		List <Member> members = memberDao.getUsersByProjectId(projectId);
		//Title of the project
	    Paragraph title = new Paragraph(project.getName(), titleBold);
	    addEmptyLine(title, 9);
	    title.setAlignment(Paragraph.ALIGN_CENTER);
	    document.add(title);
	    //Date of generation of the Document 
	    Date date = new Date();
	    String day = new SimpleDateFormat("dd").format(date);
	    String month = new SimpleDateFormat("MMMM").format(date);
	    String year = new SimpleDateFormat("YYYY").format(date);
        Paragraph dateF = new Paragraph(day + " de "+ month + " de " + year, titleBold);
        addEmptyLine(dateF, 1);
        dateF.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(dateF);
        //Version of the document
        Paragraph vers = new Paragraph("Versión "+ srs.getVersion(), titleBold);
        vers.setAlignment(Paragraph.ALIGN_CENTER);
        addEmptyLine(vers, 5);
        document.add(vers);
        //Members of the project
        for (Member m : members) {
			final User user = userDao.getUserById(m.getUserId());
			Paragraph usr = new Paragraph(user.getFirstname()+" "+user.getLastname(),titleBold);
			usr.setAlignment(Paragraph.ALIGN_CENTER);
			//addEmptyLine(usr,1);
	        document.add(usr);
		}
        // Start a new page
    }
	private void addContentTable(Document document, Font titleBold, int projectId) {
		
	}
	
	private void addIntroduction(Document document,Font header1, Font header2, Font textP, int projectId)throws DocumentException {
		final SRS srs = srsDao.getSRSByProjectId(projectId);
		Paragraph mainTitle = new Paragraph("1. Introducción ", header1);
		document.add(mainTitle);
		Paragraph purpose = new Paragraph("1.1. Próposito del sistema", header2);
		purpose.setIndentationLeft(15);
		addEmptyLine(purpose, 1);
		document.add(purpose);
		Paragraph purposeContent = new Paragraph(srs.getSystemProspect(), textP);
		purposeContent.setIndentationLeft(30);
		purposeContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(purposeContent, 1);
		document.add(purposeContent);
		Paragraph scope = new Paragraph ("1.2. Alcance",header2);
		scope.setIndentationLeft(15);
		addEmptyLine(scope, 1);
		document.add(scope);
		Paragraph scopeContent= new Paragraph(srs.getScope(),textP);
		scopeContent.setIndentationLeft(30);
		scopeContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(scopeContent, 1);
		document.add(scopeContent);
		Paragraph objectives = new Paragraph ("1.3. Objetivos y restricciones de diseño",header2);
		objectives.setIndentationLeft(15);
		addEmptyLine(objectives, 1);
		document.add(objectives);
		Paragraph objectivesContent= new Paragraph(srs.getObjectives(),textP);
		objectivesContent.setIndentationLeft(30);
		objectivesContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(objectivesContent, 1);
		document.add(objectivesContent);
		Paragraph definitions = new Paragraph ("1.4. Definiciones, acrónimos y abreviaturas",header2);
		definitions.setIndentationLeft(15);
		addEmptyLine(definitions, 1);
		document.add(definitions);
		Paragraph definitionsContent= new Paragraph(srs.getDefinitions(),textP);
		definitionsContent.setIndentationLeft(30);
		definitionsContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(definitionsContent, 1);
		document.add(definitionsContent);
		Paragraph references = new Paragraph ("1.5. Referencias",header2);
		references.setIndentationLeft(15);
		addEmptyLine(references, 1);
		document.add(references);
		Paragraph referencesContent= new Paragraph(srs.getReferencs(),textP);
		referencesContent.setIndentationLeft(30);
		referencesContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(referencesContent, 1);
		document.add(referencesContent);
		Paragraph globalA = new Paragraph ("1.6. Apreciación Global",header2);
		globalA.setIndentationLeft(15);
		addEmptyLine(globalA, 1);
		document.add(globalA);
		Paragraph globalAContent= new Paragraph(srs.getGlobalAppraisal(),textP);
		globalAContent.setIndentationLeft(30);
		globalAContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(globalAContent, 1);
		document.add(globalAContent);
	}
	
	private void addGlobalDescription(Document document,Font header1, Font header2, Font header3,Font textP, int projectId)throws DocumentException, IOException {
		final SRS srs = srsDao.getSRSByProjectId(projectId);
		Paragraph mainTitle = new Paragraph("2. Descripción Global ", header1);
		document.add(mainTitle);
		Paragraph productPersp = new Paragraph("2.1. Perspectiva del Producto", header2);
		productPersp.setIndentationLeft(15);
		addEmptyLine(productPersp, 1);
		document.add(productPersp);
		Paragraph productPerspContent = new Paragraph(srs.getProductPerspective(), textP);
		productPerspContent.setIndentationLeft(30);
		productPerspContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(productPerspContent, 1);
		document.add(productPerspContent);
		Paragraph interfaces = new Paragraph ("2.1.1. Interfaces",header3);
		interfaces.setIndentationLeft(30);
		addEmptyLine(interfaces, 1);
		document.add(interfaces);
		Paragraph interfacesContent= new Paragraph(srs.getInterfaces(),textP);
		interfacesContent.setIndentationLeft(45);
		interfacesContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(interfacesContent, 1);
		document.add(interfacesContent);
		Paragraph userChar = new Paragraph ("2.2. Características del Usuario",header2);
		userChar.setIndentationLeft(15);
		addEmptyLine(userChar, 1);
		document.add(userChar);
		Paragraph userCharContent= new Paragraph(srs.getUserCharacteristics(),textP);
		userCharContent.setIndentationLeft(30);
		userCharContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(userCharContent, 1);
		document.add(userCharContent);
		Paragraph productFunctions = new Paragraph ("2.3. Funciones del Producto",header2);
		productFunctions.setIndentationLeft(15);
		addEmptyLine(productFunctions, 1);
		document.add(productFunctions);
		Paragraph productFunctionsContent= new Paragraph(srs.getProductFunctions(),textP);
		productFunctionsContent.setIndentationLeft(30);
		productFunctionsContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(productFunctionsContent, 1);
		document.add(productFunctionsContent);
		Paragraph domainModel = new Paragraph ("2.4. Modelo del dominio",header2);
		domainModel.setIndentationLeft(15);
		addEmptyLine(domainModel, 1);
		document.add(domainModel);
		Paragraph warn= new Paragraph("Si adjuntó el diagrama de contexto este aparecerá al final de documento en la sección de imágenes.",textP);
		warn.setIndentationLeft(30);
		warn.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(warn, 1);
		document.add(warn);
		Paragraph restrictions = new Paragraph ("2.5. Restricciones",header2);
		restrictions.setIndentationLeft(15);
		addEmptyLine(restrictions, 1);
		document.add(restrictions);
		Paragraph restrictionsContent= new Paragraph(srs.getRestrictions(),textP);
		restrictionsContent.setIndentationLeft(30);
		restrictionsContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(restrictionsContent, 1);
		document.add(restrictionsContent);
		Paragraph supositions = new Paragraph ("2.6. Suposiciones y dependencias",header2);
		supositions.setIndentationLeft(15);
		addEmptyLine(supositions, 1);
		document.add(supositions);
		Paragraph supositionsContent= new Paragraph(srs.getSuppositions(),textP);
		supositionsContent.setIndentationLeft(30);
		supositionsContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(supositionsContent, 1);
		document.add(supositionsContent);
	}

	private void addRequirements(Document document, Font header1, Font header2, Font header3, Font textP, Font textPB, int projectId)throws DocumentException {
		List <Requirement> requirements = requirementDao.getRequirementByProjectId(projectId);
		final Project project = projectDao.getProjectById(projectId);
		final SRS srs = srsDao.getSRSByProjectId(projectId);
		Paragraph mainTitle = new Paragraph("3.	Requerimientos Específicos  ", header1);
		document.add(mainTitle);
		Paragraph reqFunctional = new Paragraph("3.1. Requerimientos Funcionales", header2);
		reqFunctional.setIndentationLeft(15);
		addEmptyLine(reqFunctional, 1);
		document.add(reqFunctional);
		int numRNF = 0;
		List <Requirement> requirementsNF= new ArrayList<Requirement>();
		for (Requirement r : requirements) {
			List <Specification> specifications = specificationDao.getSpecificationByRequirementId(r.getId());
			if (specifications.isEmpty()) {
				if (r.getType().equals("RNF")) {
					numRNF+=1;
					requirementsNF.add(r);
				}
				
			}else {
				Specification spc = specifications.get(0);
			      PdfPTable table = new PdfPTable(5);
			      PdfPCell c1 = new PdfPCell(new Phrase(project.getName()+"\n"+"SRS-Especificación de Requerimientos",textPB));
			      c1.setColspan(5);
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase("Código",textPB));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);

			      c1 = new PdfPCell(new Phrase("Nombre",textPB));
			      c1.setColspan(2);
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);

			      c1 = new PdfPCell(new Phrase("Fecha",textPB));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase("Grado de necesidad",textPB));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			     
			      c1 = new PdfPCell(new Phrase(spc.getCode(),textP));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase(spc.getName(),textP));
			      c1.setColspan(2);
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      Date date = spc.getDate();
				  String day = new SimpleDateFormat("dd").format(date);
				  String month = new SimpleDateFormat("MM").format(date);
				  String year = new SimpleDateFormat("YYYY").format(date);
			      c1 = new PdfPCell(new Phrase(year+"-"+month+"-"+day,textP));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase(spc.getGradeOfNeed(),textP));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase("Descripción",textPB));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase(spc.getDescription(),textP));
			      c1.setColspan(4);
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase("Entradas",textPB));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase("Fuente",textPB));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase("Salida",textPB));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase("Destino",textPB));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase("Restricciones",textPB));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);	
			      
			      c1 = new PdfPCell(new Phrase(spc.getEntry(),textP));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase(spc.getFont(),textP));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase(spc.getOutt(),textP));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase(spc.getDestiny(),textP));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase(spc.getRestriction(),textP));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase("Proceso",textPB));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase(spc.getProcess(),textP));
			      c1.setColspan(4);
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase("Efecto Colateral",textPB));
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      c1 = new PdfPCell(new Phrase(spc.getColateralEffect(),textP));
			      c1.setColspan(4);
			      c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			      table.addCell(c1);
			      
			      document.add(table);
			      Paragraph prg = new Paragraph(" ");
			      document.add(prg);
			      
			}
		}
		Paragraph reqDB = new Paragraph("3.2. Requerimientos de la Base de Datos", header2);
		reqDB.setIndentationLeft(15);
		addEmptyLine(reqDB, 1);
		document.add(reqDB);
		Paragraph reqDBContent = new Paragraph(srs.getDBRequirements(),textP);
		reqDBContent.setIndentationLeft(30);
		reqDBContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(reqDBContent, 1);
		document.add(reqDBContent);
		Paragraph designRestrictions = new Paragraph("3.3. Restricciones del Diseño", header2);
		designRestrictions.setIndentationLeft(15);
		addEmptyLine(designRestrictions, 1);
		document.add(designRestrictions);
		Paragraph designRestrictionsContent = new Paragraph(srs.getDesignRestrictions(),textP);
		designRestrictionsContent.setIndentationLeft(30);
		designRestrictionsContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(designRestrictionsContent, 1);
		document.add(designRestrictionsContent);
		Paragraph ruleAcceptance = new Paragraph("3.3.1. Aceptación de las normas", header3);
		ruleAcceptance.setIndentationLeft(30);
		addEmptyLine(ruleAcceptance, 1);
		document.add(ruleAcceptance);
		Paragraph ruleAcceptanceContent = new Paragraph(srs.getRuleAcceptance(),textP);
		ruleAcceptanceContent.setIndentationLeft(45);
		ruleAcceptanceContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(ruleAcceptanceContent, 1);
		document.add(ruleAcceptanceContent);
		Paragraph reqNF = new Paragraph("3.4. Requerimientos no Funcionales", header2);
		reqNF.setIndentationLeft(15);
		addEmptyLine(reqNF, 1);
		document.add(reqNF);
		for (int i=1;i<=numRNF;i++) {
			Paragraph requirementNF = new Paragraph("3.4."+Integer.toString(i)+". "+requirementsNF.get(i-1).getName(), header3);
			requirementNF.setIndentationLeft(30);
			document.add(requirementNF);
			Paragraph requirementNFContent = new Paragraph(requirementsNF.get(i-1).getDescription(),textP);
			requirementNFContent.setIndentationLeft(45);
			requirementNFContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			addEmptyLine(requirementNFContent, 1);
			document.add(requirementNFContent);
		}
		
	}
	private void addImages(Document document, Font header1,Font header2, Font textP, int projectId) throws MalformedURLException, IOException, DocumentException {
		final SRS srs = srsDao.getSRSByProjectId(projectId);
		Paragraph mainTitle = new Paragraph("4. Imágenes", header1);
		document.add(mainTitle);
		Paragraph dContext = new Paragraph ("4.1 Diagrama de contexto",header2);
		dContext.setIndentationLeft(15);
		addEmptyLine(dContext, 1);
		document.add(dContext);
		List<byte[]> bytes = imageDao.getPhotoByNameAndProject("Diagrama de contexto", projectId);
		if (bytes.isEmpty()) {
			
		}else {
			byte [] bytes1=bytes.get(0);
			Image image1 = Image.getInstance(bytes1);
			image1.scaleAbsolute(300,300);
			document.add(image1);
		}
		
		Paragraph domainModelContent= new Paragraph(srs.getDomainModel(),textP);
		domainModelContent.setIndentationLeft(30);
		domainModelContent.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		addEmptyLine(domainModelContent, 1);
		document.add(domainModelContent);
		document.newPage();
		Paragraph dSecuen = new Paragraph ("4.2 Diagramas de secuencia",header2);
		dSecuen.setIndentationLeft(15);
		addEmptyLine(dSecuen, 1);
		document.add(dSecuen);
		List<byte[]> bytes2 = imageDao.getPhotoByNameAndProject("Diagrama de secuencia", projectId);
		if (bytes2.isEmpty()){	
		}else {
			for (byte[] b: bytes2) {
				Image image2 = Image.getInstance(b);
				image2.scaleAbsolute(300,300);
				document.add(image2);
				
			}
		}
		
	}
	//Store the old versions of the SRS in a historical.
	@Override 
	public void saveVersionSRS(SRS srs) {
		srsDao.saveVersionSRS(srs);
	}
	

}
