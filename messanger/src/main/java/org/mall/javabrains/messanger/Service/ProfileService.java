package org.mall.javabrains.messanger.Service;



import java.util.List;

import java.util.*;

import org.mall.javabrains.messanger.database.DatabaseClass;

import org.mall.javabrains.messanger.model.Profile;


public class ProfileService {

	



	

		private static Map<String, Profile> profiles  = DatabaseClass.getProfiles();

		/*
		 * public List<Message> getAllMessages() {
		 * 
		 * Message m1 =new Message (1L,"hello" ,"Mall");
		 * 
		 * 
		 * Message m2 =new Message (2L,"hallo" ,"kumar");
		 * 
		 * Message m3 =new Message (3L,"hii" ,"Mall");
		 * 
		 * 
		 * List<Message> list =new ArrayList<>();
		 * 
		 * list.add(m1); list.add(m2); list.add(m3);
		 * 
		 * return list; }
		 */

		
		public ProfileService()
		{
			
		}	static {
			profiles.put("AM",new Profile (1L,"AM" ,"Anurag","Mall"));
			
			profiles.put("BM",new Profile (2L,"BM" ,"Anju","Mall"));
			
		}
		
		
		public List<Profile> getAllProfiles() {

			return new ArrayList<Profile>(profiles.values());

		}

		public Profile getProfile(String ProfileName) {
			return profiles.get(ProfileName );
		}

		public Profile removeProfile(String ProfileName)

		{
			return profiles.remove(ProfileName);

		}

		public Profile updateProfile(Profile profile)

		{
			if (profile.getProfileName().isEmpty()) {
				return null;

			}
			profiles.put(profile.getProfileName(), profile);

			return profile;
		}

		public Profile addProfile(Profile profile)

		{
			profile.setId(profiles.size() + 1);

			profiles.put(profile.getProfileName(), profile);

			return profile;
		}

	}

	

