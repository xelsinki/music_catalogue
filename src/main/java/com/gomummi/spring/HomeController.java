package com.gomummi.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;



/**
 * HomeController is my MVC application`s controller,
 * here is methods for Create, Find, List and Delete MP3 objects from database.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//	@Autowired
//	private MessageSource messageSource;
	
	@Inject
	private MP3DAO dao;

	public MP3DAO getDao() {
		return dao;
	}
	public void setDao(MP3DAO dao) {
		this.dao = dao;
	}

	/**
	 * This method for first view of application.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute MP3 mp3, Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	/**
	 * This method create object for form.
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	// Metodi palauttaa ModelAndView objekti tietoinen
	public ModelAndView form() {
		
		
		return new ModelAndView("create", "mp3", new MP3());
	}

	/**
	 * This method validate object from form, 
	 * save it to database and redirect to another view using PRG pattern.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createMP3(Locale locale, @Valid @ModelAttribute(value = "mp3") MP3 mp3, BindingResult bindingResult, Model model, ModelMap modelMap, RedirectAttributes redirectAttributes) {

		ModelAndView modelAndView = new ModelAndView();
	
		if (bindingResult.hasErrors()) {
						
			modelAndView.setViewName("create");
						
		} else {
			
			// Insert
			dao.insert(mp3);
			redirectAttributes.addFlashAttribute("redirect", true);
			modelAndView.setViewName("redirect:/" + mp3.getId());
		}

		return modelAndView;
		
		// Metodin vanhempi versio, kun return type oli String
		
		// Validation
//		if (bindingResult.hasErrors()) {
//			return "create";
//		}
//		// Insert
//		dao.insert(mp3);
//		
//		redirectAttributes.addFlashAttribute("redirect", true);
//		// Redirect tapahtuu view.jsp:lle, sinne lähtee luotun olion id 
//		  return "redirect:/" + mp3.getId();
//		  // Tapahtuma jatkuu seuraavassa metodissa
	}

	/**
	 * This method show just created object.
	 */
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(HttpServletRequest request, @PathVariable Integer id, Model model) {
		
		// Tämä lähettää konsoliin ilmoitus redirect/update tilasta
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		if (map != null) {
			logger.info("redirect!");
		} else {
			logger.info("update!");
		}
		
		// Haetaan laulun tiedot id:lla
		MP3 mp3 = dao.find(id);
		model.addAttribute("mp3", mp3);
		return "view";
	}
	
	/**
	 * This method delete selected object from database.
	 */
	// Poisto tapahtuu POST metodilla, joka suojaa SQL-injection:ilta
	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public String delete(HttpServletRequest request, @PathVariable Integer id, Model model) {
		
		// Poistetaan laulun tiedot id:lla
		dao.delete(id);
		// model.addAttribute("mp3", mp3);
		return  "redirect:/list";
	}
	
	/**
	 * This method list all objects from database.
	 * 
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllPersons(Model model) {
		List<MP3> mp3 = dao.getAll();
		model.addAttribute("mp3", mp3);
		return "list";
	}
}

	


