//package edu.vanderbilt.wall.wall;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import org.hamcrest.Matchers;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(WallController.class)
//public class WallApplicationTests {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	private ObjectMapper objectMapper = new ObjectMapper();
//
//	@Test
//    public void testPostingAndListing() throws Exception {
//
//    	List<String[]> mockData = new ArrayList<String[]>();
//    	List<Post> mockSavedData = new ArrayList<>();
//
//    	int fakePostCount = (int) Math.rint(Math.random() * 500);
//
//    	for(int i = 0; i < fakePostCount; i++) {
//    		String user = UUID.randomUUID().toString();
//    		String content = UUID.randomUUID().toString();
//
//    		mockData.add(new String[] {user, content});
//
//	        String resultJson = this.mockMvc.perform(get("/posts/add?user="+user+"&content="+content))
//		        .andExpect(status().isOk())
//		        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//		        .andExpect(jsonPath("$.user", is(user)))
//		        .andExpect(jsonPath("$.content", is(content)))
//		        .andReturn().getResponse().getContentAsString();
//
//	        mockSavedData.add( objectMapper.readValue(resultJson, Post.class) );
//
//    	}
//
//    	// +20pts
//
//        ResultActions results = this.mockMvc.perform(get("/posts"))
//        	.andExpect(status().isOk())
//        	.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//        	.andExpect(jsonPath("$", hasSize(fakePostCount)));
//
//        for(int i = 0; i < fakePostCount; i++) {
//        	results.andExpect(jsonPath("$["+i+"].user", is(mockData.get(i)[0])))
//        			.andExpect(jsonPath("$["+i+"].content", is(mockData.get(i)[1])));
//        }
//
//        // +20pts
//
//        for(int i = 0; i < mockData.size(); i++) {
//        	this.mockMvc.perform(get("/posts/" + mockSavedData.get(i).getId()))
//	        .andExpect(status().isOk())
//	        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//	        .andExpect(jsonPath("$.user", is(mockData.get(i)[0])))
//	        .andExpect(jsonPath("$.content", is(mockData.get(i)[1])));
//        }
//
//        // + 20pts
//
//
//    	ResultActions result = this.mockMvc.perform(get("/wall"))
//		        .andExpect(status().isOk())
//		        .andExpect(content().contentType("text/html;charset=UTF-8"));
//
//    	for(Post p : mockSavedData) {
//    		result.andExpect(content().string(Matchers.containsString(p.getContent())))
//    			  .andExpect(content().string(Matchers.containsString(p.getUser())));
//    	}
//
//    	// + 40pts
//
//	}
//}
