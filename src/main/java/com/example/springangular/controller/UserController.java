package com.example.springangular.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.example.springangular.entity.GroupLight;
import com.example.springangular.entity.Group_table;
import com.example.springangular.entity.Light_table;
import com.example.springangular.entity.UserGroup;
import com.example.springangular.entity.UserLight;
import com.example.springangular.entity.User_details_table;
import com.example.springangular.model.Response;
import com.example.springangular.pojo.CreateGroupRequest;
import com.example.springangular.pojo.CreateUserRequest;
import com.example.springangular.repository.GroupRepository;
import com.example.springangular.repository.SpringRepository;
import com.example.springangular.repository.UserGroupRepository;
import com.example.springangular.repository.UserLightRepository;
import com.example.springangular.repository.UserRepository;
import com.example.springangular.service.UserService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/user-details-table")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private SpringRepository springRepository;


	@Autowired
	private UserGroupRepository userGroupRepository;

	@Autowired
	private UserLightRepository userLightRepository;

	@GetMapping("/login")
	public ResponseEntity<?> getLog() {

		try {

			List<User_details_table> userList = userRepository.findAll();
			JsonArray userArray = new JsonArray();
			for (User_details_table userTable : userList) {
				JsonObject userOb = new JsonObject();
				userOb.addProperty("userId", userTable.getUser_id());
				userOb.addProperty("userName", userTable.getUserName());
				userOb.addProperty("password", userTable.getPassword());
				userOb.addProperty("userType", userTable.getUserType());
				userArray.add(userOb);
			}
			return ResponseEntity.status(HttpStatus.OK).body(userArray.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("log Not received");
		}

	}

	@GetMapping
	public ResponseEntity<?> getGroup() {

		try {
//			List<DisplayGroupRequest>displayGroupRequest=groupRepository.findGroupLight();
//			JsonArray  ja=new JsonArray();
//			 for(DisplayGroupRequest dr: displayGroupRequest) {
//			  
//				 JsonObject jo= new JsonObject();
//				  jo.addProperty("group_name",8);
//				  jo.addProperty("light_id",dr.getLight_id());
//				  ja.add(jo);
//				  
//			 }
//			 

			List<User_details_table> userList = userRepository.findAll();
			JsonArray usergrpLight = new JsonArray();
			for (User_details_table userTable : userList) {
				JsonObject usergroupLight = new JsonObject();
				usergroupLight.addProperty("userId", userTable.getUser_id());
				usergroupLight.addProperty("userName", userTable.getUserName());
				usergroupLight.addProperty("firstName", userTable.getFirstName());
				usergroupLight.addProperty("lastname", userTable.getLastName());
				usergroupLight.addProperty("password", userTable.getPassword());
				usergroupLight.addProperty("userType", userTable.getUserType());

				List<UserGroup> groupList = userGroupRepository.findByUserId(userTable.getUser_id());
				JsonArray grpList = new JsonArray();
				for (UserGroup grp : groupList) {
					grpList.add(grp.getGroup_id());
				}
				usergroupLight.add("groupId", grpList);

				List<UserLight> lightList = userLightRepository.findByUserId(userTable.getUser_id());
				JsonArray litList = new JsonArray();
				for (UserLight lit : lightList) {
					litList.add(lit.getLight_id());
				}
				usergroupLight.add("lightId", litList);

				usergrpLight.add(usergroupLight);
			}

//			 
			return ResponseEntity.status(HttpStatus.OK).body(usergrpLight.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user Not received");
		}

	}

//	@PostMapping
//	public ResponseEntity<Response> save(@RequestBody User_details_table user_details_table) {
//		return ResponseEntity.status(HttpStatus.OK)
//				.body(new Response(userService.save(user_details_table), new Date()));
//	}

	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request) {

		try {
			User_details_table userTable = new User_details_table();
			userTable.setUserName(request.getUserName());
			userTable.setFirstName(request.getFirstName());
			userTable.setLastName(request.getLastName());
			userTable.setPassword(request.getPassword());
			userTable.setUserType(request.getUserType());
			userRepository.saveAndFlush(userTable);

			Integer userId = userRepository.findLastCreatedUser();
			for (Integer groupId : request.getUsergroupIdList()) {
				UserGroup userGroup = new UserGroup();
				userGroup.setUser_id(userId);
				userGroup.setGroup_id(groupId);
				userGroupRepository.saveAndFlush(userGroup);
			}
			Integer userIdL = userRepository.findLastCreatedUser();
			for (Integer lightId : request.getUserlightIdList()) {
				UserLight userLight = new UserLight();
				userLight.setUser_id(userIdL);
				userLight.setLight_id(lightId);
				userLightRepository.saveAndFlush(userLight);
			}

			return ResponseEntity.status(HttpStatus.OK).body("user Created");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user Not Created");
		}
	}

	@PostMapping("/group-display")
	public ResponseEntity<?> displayUserGroup(@RequestBody CreateUserRequest request) {

		try {
			List<UserGroup> userGrp = userGroupRepository.findByUserId(request.getUserId());

			JsonObject usergrpLight = new JsonObject();
			JsonArray grpArray = new JsonArray();
			for (UserGroup userGroup : userGrp) {
				Group_table grpTable = groupRepository.findById(userGroup.getGroup_id()).get();
				grpArray.add(grpTable.getGroupName());

			}

			usergrpLight.add("groupName", grpArray);

			return ResponseEntity.status(HttpStatus.OK).body(usergrpLight.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user Not Created");
		}
	}

	@PostMapping("/light-display")
	public ResponseEntity<?> displayUserLight(@RequestBody CreateUserRequest request) {

		try {
			List<UserLight> userLgt = userLightRepository.findByUserId(request.getUserId());

			JsonObject usergrpLight = new JsonObject();
			JsonArray lgtArray = new JsonArray();
			for (UserLight userLight : userLgt) {
				Light_table lgtTable = springRepository.findById(userLight.getLight_id()).get();
				lgtArray.add(lgtTable.getLightName());

			}

			usergrpLight.add("lightName", lgtArray);

			return ResponseEntity.status(HttpStatus.OK).body(usergrpLight.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user Not Created");
		}
	}
//	@PostMapping
//	public ResponseEntity<Response> save(@RequestBody User_details_table user_details_table) {
//		return ResponseEntity.status(HttpStatus.OK)
//				.body(new Response(userService.save(user_details_table), new Date()));
//	}	

//	@PutMapping
//	public ResponseEntity<Response> update(@RequestBody User_details_table user_details_table) {
//		return ResponseEntity.status(HttpStatus.OK)
//				.body(new Response(userService.save(user_details_table), new Date()));
//	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody CreateUserRequest request) {

		try {
			User_details_table userTable = userRepository.findById(request.getUserId()).get();
			userTable.setUserName(request.getUserName());
			userTable.setFirstName(request.getFirstName());
			userTable.setLastName(request.getLastName());
			userTable.setPassword(request.getPassword());
			userTable.setUserType(request.getUserType());
			userRepository.saveAndFlush(userTable);

//			Integer userId = request.getUserId();
//			for (Integer groupId : request.getUsergroupIdList()) {
//				UserGroup userGroup = new UserGroup();
//				userGroup.setUser_id(userId);
//				userGroup.setGroup_id(groupId);
//				userGroupRepository.saveAndFlush(userGroup);
//			}
//			Integer userIdL = request.getUserId();
//			for (Integer lightId : request.getUserlightIdList()) {
//				UserLight userLight = new UserLight();
//				userLight.setUser_id(userIdL);
//				userLight.setLight_id(lightId);
//				userLightRepository.saveAndFlush(userLight);
//			}

			return ResponseEntity.status(HttpStatus.OK).body("user Created");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user Not Created");
		}
	}

	@PostMapping("/delete-user")
	public ResponseEntity<?> delete(@RequestBody CreateUserRequest request) {

		try {

//			UserGroup userGroup = userGroupRepository.findById(request.getUserId()).get();
//			userGroupRepository.delete(userGroup);
//			UserLight userLight=userLightRepository.findById(request.getUserId()).get();
//			userLightRepository.delete(userLight);
			User_details_table userTable = userRepository.findById(request.getUserId()).get();
			userRepository.delete(userTable);

//			userService.delete(user_id);
			return ResponseEntity.status(HttpStatus.OK).body("user deleted");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user Not deleted");
		}

	}
}