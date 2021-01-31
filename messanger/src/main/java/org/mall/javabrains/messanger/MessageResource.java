package org.mall.javabrains.messanger;


import java.util.List;


import org.mall.javabrains.messanger.Service.MessageService;
import org.mall.javabrains.messanger.model.Message;

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
@Path("/myresource")
public class MessageResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	
	MessageService messageservice =new MessageService();
	
	 
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
      
    	
		return messageservice.getAllMessages();
    }
    
    
    
    @GET
    @Path("/{messageid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message  getMessage(@PathParam ("messageid") Long id) {
      
    	
		 return  messageservice.getMessage(id);
    }
    
    
    
    @POST
   @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message  addMessage(Message message) {
      
    	
		 return  messageservice.addMessage(message);
    }
    
    @DELETE
    @Path("/{messageid}")
    @Produces(MediaType.APPLICATION_JSON)
     public void   deleteMessage(@PathParam ("messageid")  long  id ) {
       
     	
 		  messageservice.removeMessage(id);
     }
    
    @PUT
    @Path("/{messageid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
     public Message  updateMessage(@PathParam ("messageid")  long  id ,Message message) {
       
     	message.setId(id);
 		 return  messageservice.updateMessage(message);
     }
}

