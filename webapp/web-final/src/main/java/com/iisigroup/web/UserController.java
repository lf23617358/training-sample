package com.iisigroup.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.iisigroup.datatable.TableInput;
import com.iisigroup.datatable.TableOutput;
import com.iisigroup.dto.UserDto;
import com.iisigroup.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	private UserService userService;

	@GetMapping
	public String userPage() {
		return "user";
	}

	@PostMapping("listUser")
	@ResponseBody
	public TableOutput<UserDto> listUser(@RequestBody TableInput<UserDto> tableInput) {
		TableOutput<UserDto> tableOutput = new TableOutput<>();

		List<UserDto> dtos = userService.findByExample(tableInput.getRqObj());
		tableOutput.setTotal(ObjectUtils.isEmpty(dtos) ? 0 : dtos.size());
		tableOutput.setRows(ObjectUtils.isEmpty(dtos) ? new ArrayList<UserDto>() : dtos);
		return tableOutput;
	}

	@PostMapping("createUser")
	@ResponseBody
	public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
		userService.insert(userDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("updateUser")
	@ResponseBody
	public ResponseEntity<String> updateUser(@RequestBody UserDto userDto) {
		userService.update(userDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("deleteUser")
	@ResponseBody
	public ResponseEntity<String> deleteUser(@RequestBody Long[] ids) {
		userService.delete(ids);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
