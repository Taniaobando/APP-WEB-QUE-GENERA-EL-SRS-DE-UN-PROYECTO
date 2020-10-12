package com.proyectofinal.web.dao;

import java.util.List;
import com.proyectofinal.web.model.Member;
/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email: lauarangom@gmail.com
 * Creation date: 09/05/2019
 * Last modification: 23/05/2019
 */
public interface MemberDao {
	//Returns all the members of a project.
	List<Member> getUsersByProjectId(int id);
	//Associates a user whit a project.
	void linkProjectWithUser(int projectId, String role, int userId);
	//Returns the Role of a id of user given.
	Member getMemberByUpId(final int userId,final int projectId);
}
