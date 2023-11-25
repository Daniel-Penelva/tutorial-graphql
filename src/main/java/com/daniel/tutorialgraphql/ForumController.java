package com.daniel.tutorialgraphql;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ForumController {
    
    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    //@SchemaMapping(typeName = "Query", value = "postByid")
    @QueryMapping
    public Post postById(@Argument String id){
        return postService.postByid(id);
    }

    @MutationMapping
    public Collection<Post> createPost(@Argument String content){
        return postService.createPost(content);
    }

    @MutationMapping
    public Collection<Comment> createComment(@Argument String content,@Argument String postId){
        return commentService.createComment(content, postId);
    }
}
