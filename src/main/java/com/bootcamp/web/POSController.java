package com.bootcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
public class POSController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("secure/beranda")
	public String beranda() {
		return "beranda";
	}

	@RequestMapping("secure/user")
	public String user() {
		return "user-data";
	}

	@PreAuthorize("hasAnyAuthority('user', 'admin')")
	@RequestMapping("secure/barang")
	public String barang() {
		return "barang";
	}

	@PreAuthorize("hasAnyAuthority('admin')")
	@RequestMapping("secure/order")
	public String order() {
		return "order";
	}
}