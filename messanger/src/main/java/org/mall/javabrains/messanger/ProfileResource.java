package org.mall.javabrains.messanger;


import java.util.List;



import org.mall.javabrains.messanger.Service.ProfileService;

import org.mall.javabrains.messanger.model.Profile;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/profiles")
public class ProfileResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	
	ProfileService profileservice =new ProfileService();
	
	 
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getprofiles() {
      
    	
		return profileservice.getAllProfiles();
    }
    
    
    
    @GET
    @Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile  getProfile(@PathParam ("profileName") String  profileName) {
      
    	
		 return  profileservice.getProfile(profileName);
    }
    
    
    
    @POST
   @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile  addMessage(Profile profile) {
      
    	
		 return  profileservice.addProfile(profile);
    }
    
    @DELETE
    @Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
     public void   deleteProfile(@PathParam ("profileName")  String   profileName ) {
       
     	
    	profileservice.removeProfile (profileName );
     }
    
    @PUT
    @Path("/{profileName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
     public Profile  updateProfile(@PathParam ("profileName") String  profileName,Profile profile) {
       
     	profile.setProfileName(profileName);
 		 return  profileservice.updateProfile(profile);
     }
}


