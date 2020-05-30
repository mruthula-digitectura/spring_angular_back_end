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
import com.example.springangular.entity.User_details_table;
import com.example.springangular.model.Response;
import com.example.springangular.pojo.CreateGroupRequest;
import com.example.springangular.pojo.DisplayGroupRequest;
import com.example.springangular.repository.GroupLightRepository;
import com.example.springangular.repository.GroupRepository;
import com.example.springangular.repository.SpringRepository;
import com.example.springangular.service.GroupService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/group-table")
public class GroupController {

	@Autowired
	private GroupService groupService;

	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private SpringRepository springRepository;

	@Autowired
	private GroupLightRepository groupLightRepository;

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

			List<Group_table> groupList = groupRepository.findAll();
			JsonArray grpLight = new JsonArray();
			for (Group_table grpTable : groupList) {
				JsonObject groupLight = new JsonObject();
				groupLight.addProperty("groupId", grpTable.getGroup_id());
				groupLight.addProperty("groupName", grpTable.getGroupName());
				List<GroupLight> lightList = groupLightRepository.findByGroupId(grpTable.getGroup_id());
				JsonArray litList=new JsonArray();
				for(GroupLight lit:lightList) {
					litList.add(lit.getLight_id());
				}
				groupLight.add("lightId",litList);
				grpLight.add(groupLight);
			}

//			 for(Light_table lightTable:lightList)
//			 {
//				 JsonObject light=new  JsonObject();
//				 light.addProperty("lightId", lightTable.getLight_id());
//			 }
			return ResponseEntity.status(HttpStatus.OK).body(grpLight.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("group Not received");
		}

	}
	
	

//	@PostMapping
//	public ResponseEntity<Response> save(@RequestBody Group_table group_table) {
//		return ResponseEntity.status(HttpStatus.OK).body(new Response(groupService.save(group_table), new Date()));
//	}

	@PostMapping
	public ResponseEntity<?> createGroup(@RequestBody CreateGroupRequest request) {

		try {
			Group_table grpTable = new Group_table();
			grpTable.setGroupName(request.getGroupName());
			groupRepository.saveAndFlush(grpTable);

			Integer grpId = groupRepository.findLastCreatedGroup();
			for (Integer lightId : request.getLightIdList()) {
				GroupLight groupLight = new GroupLight();
				groupLight.setGroup_id(grpId);
				groupLight.setLight_id(lightId);
				groupLightRepository.saveAndFlush(groupLight);
			}
			return ResponseEntity.status(HttpStatus.OK).body("Group Created");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Group Not Created");
		}
	}

//	@PutMapping
//	public ResponseEntity<Response> update(@RequestBody Group_table group_table) {
//		return ResponseEntity.status(HttpStatus.OK).body(new Response(groupService.save(group_table), new Date()));
//	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody CreateGroupRequest request) {

		try {
			Group_table grpTable = groupRepository.findById(request.getGroupId()).get();
			grpTable.setGroupName(request.getGroupName());
			groupRepository.saveAndFlush(grpTable);

//			Integer grpId = groupRepository.findLastCreatedGroup();
//			for (Integer lightId : request.getLightIdList()) {
//				GroupLight groupLight = new GroupLight();
//				groupLight.setGroup_id(grpId);
//				groupLight.setLight_id(lightId);
//				groupLightRepository.saveAndFlush(groupLight);
//			}
			return ResponseEntity.status(HttpStatus.OK).body("Group Created");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Group Not Created");
		}
	}

	@PostMapping("/delete-group")
	public ResponseEntity<?> delete(@RequestBody CreateGroupRequest request) {
		
		try {
//		groupService.delete(group_id);
			
			Group_table grpTable = groupRepository.findById(request.getGroupId()).get();
			groupRepository.delete(grpTable);
		return ResponseEntity.status(HttpStatus.OK).body("group deleted");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("group Not deleted");
		}
	}
}