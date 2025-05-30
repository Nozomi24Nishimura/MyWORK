package com.example.springkadaitodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaitodo.form.ContactForm;

@Controller
public class ContactFormController {

	@GetMapping("/form")
	public String consact(Model model) {
		// すでにインスタンスが存在する場合は行わない
		if (!model.containsAttribute("form")) {
			// ビューにフォームクラスのインスタンスを渡す
			model.addAttribute("form", new ContactForm());
		}

		return "contactFormView";
	}

	
	@PostMapping("/confirm")
	public String confirm(RedirectAttributes redirectAttributes,
			@Validated ContactForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("form", form);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "form", result); 
			
			System.out.println("\n error");
			System.out.println(result);

			//return "redirect:/form";
			
			return "redirect:/contactFormView.html";
		}

		model.addAttribute("form",form);
		// エラーがない場合の処理
		return "confirmView";
	}
}
