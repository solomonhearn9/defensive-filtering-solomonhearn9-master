package edu.vanderbilt.wall.wall;
import java.util.regex.*;


import java.util.HashMap;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WallController {

	private String filterMaliciousPayloads(String comment){

		HashMap<String, String> safeTags = new HashMap<>();
		safeTags.put("span", "");
		safeTags.put("a", "");
		safeTags.put("em", "");
		safeTags.put("strong", "");
		safeTags.put("cite", "");
		safeTags.put("code", "");
		safeTags.put("ul", "");
		safeTags.put("ol", "");
		safeTags.put("li", "");
		safeTags.put("dl", "");
		safeTags.put("dt", "");
		safeTags.put("dd", "");
		safeTags.put("img", "");
		safeTags.put("p", "");
		safeTags.put("blockquote", "");
		safeTags.put("br/", "");
		safeTags.put("br", "");
		safeTags.put("table", "");
		safeTags.put("thead", "");
		safeTags.put("th", "");
		safeTags.put("tbody", "");
		safeTags.put("tr", "");
		safeTags.put("td", "");
		safeTags.put("h1", "");
		safeTags.put("h2", "");
		safeTags.put("h3", "");
		safeTags.put("h4", "");
		safeTags.put("h5", "");
		safeTags.put("div", "");
		safeTags.put("acronym", "");
		safeTags.put("abbr", "");
		safeTags.put("i", "");
		safeTags.put("table", "");

		if(comment.indexOf('<') != -1){
			int a = comment.indexOf('<');
			int b = comment.indexOf('>');

			String str = comment.substring(a+1, b);
			System.out.println(str);
			if(!safeTags.containsKey(str)){
				throw new IllegalArgumentException("Illegal");

			}

//

		}

		// @ToDoa
		// Your job is to filter out malicious payloads from
		// comment. However, your filtering must PRESERVE all
		// non-malicious html (e.g., tags like div, img, b, etc.).

		// If your code fails, either the site's functionality will
		// be broken or your site will be exposed to an XSS attack!

		// One tool you can use is Java String's replaceAll method:
		 comment = comment.replaceAll("\n", "<br>");
		comment = comment.replaceAll("'", "");
		comment = comment.replaceAll(":", "");


		// But, your users better be able to discuss Javascript. This
		// type of comment should not get filtered:
		String programmerComment = "<h1><b>javascript</b></h1> is the greatest language ever!";

		// We also don't want impact any of our users that are playwrights
		// by filtering something like this:
		String myPlay = "Jill, your new <i>script</i> is fantastic!";




		return comment;
	}


	@RequestMapping(value="/comment", produces=MediaType.TEXT_HTML_VALUE)
	public ModelAndView displayComment(String comment){

		// Your job is to make this safe without changing the template
		// code in comment.html. You must implement your safe filtering
		// logic in the filterMaliciousPayloads method.
		ModelAndView mv = new ModelAndView("comment");
		mv.addObject("comment", filterMaliciousPayloads(comment));

		return mv;
	}

	// No changing this method!
	@RequestMapping("/post")
	public ModelAndView postComment(){
		return new ModelAndView("post");
	}

}
