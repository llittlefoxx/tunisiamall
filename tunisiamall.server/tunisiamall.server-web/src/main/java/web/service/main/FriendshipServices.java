package web.service.main;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.tunisiamall.entities.Friendship;
import edu.tunisiamall.friendship.FriendshipLocal;
import virtual.entities.FriendshipRequest;

@Path("friends")
public class FriendshipServices {
	@Inject
	FriendshipLocal ejb;

	@POST
	@Path("add")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean sendFriendRequest(FriendshipRequest r) {
		return ejb.sendFriendRequest(r.idSrc, r.idDest);
	}

	@POST
	@Path("accept/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean acceptFriendRequest(@PathParam("id") int idRequest) {
		return ejb.acceptFriendRequest(idRequest);
	}

	@GET
	@Path("requests/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Friendship> getRequestFor(@PathParam("id") int idUser) {
		return ejb.getRequestFor(idUser);
	}

	@GET
	@Path("list/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Friendship> getFriendsList(@PathParam("id") int idUser) {
		return ejb.getFriendsList(idUser);
	}

	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean deleteFriend(@PathParam("id") int id) {
		return ejb.deleteFriend(id);
	}
}
