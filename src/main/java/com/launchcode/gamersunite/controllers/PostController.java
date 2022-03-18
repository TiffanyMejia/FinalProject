package com.launchcode.gamersunite.controllers;


import com.launchcode.gamersunite.models.Post;
import org.springframework.data.util.StreamUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



@Controller
@RequestMapping(value="posts")
public class PostController extends MainController {


//view all posts
    @RequestMapping(value="list")
    public String list(Model model) {
        model.addAttribute("post",postDao.findAll());
        model.addAttribute("heading","All Posts");
        return "posts/list";
    }

    @RequestMapping(value = "create-post", method = RequestMethod.GET)
    public String displayAddPost(Model model) {
        //get user
        model.addAttribute(new Post());
        model.addAttribute("heading", "Add New Post");
        return "posts/create-post";
    }

    @RequestMapping(value="create-post",method = RequestMethod.POST)
    public String addPost(Model model, @ModelAttribute @Valid Post newPost,
                          Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("heading", "Add New Post");
            return "posts/create-post";
        }
        postDao.save(newPost);
        return "redirect:view/" + newPost.getId();
    }

//view specific post
    @RequestMapping(value = "view/{postId}", method = RequestMethod.GET)
    public String viewPost(Model model, @PathVariable int postId) {
        Post post = postDao.findById(postId).get();
        model.addAttribute("post", post);
        model.addAttribute("postId", post.getId());
        return "posts/view";
    }

    @RequestMapping(value = "posts-in-category/{category}", method = RequestMethod.GET)
    public String listByCategory(Model model, @PathVariable String category) {
        model.addAttribute("post", StreamUtils.createStreamFromIterator(postDao.findAll().iterator()).filter(a -> category.equals(a.getSnake().getCategory())).iterator());
        model.addAttribute("heading", "Posts in Category: " + category);
        return "posts/posts-in-category";
    }
}