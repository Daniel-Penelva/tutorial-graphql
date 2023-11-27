package com.daniel.tutorialgraphql;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ForumController {
    
    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    // Busca todos os Post 
    //@SchemaMapping(typeName = "Query", value = "postByid")
    @QueryMapping
    public Post postById(@Argument String id){
        System.out.println("postById");
        return postService.postById(id);
    }

    // Cria um Post
    @MutationMapping
    public Collection<Post> createPost(@Argument String content){
        return postService.createPost(content);
    }

    // Cria Comentários (comment) associado a um Post
    @MutationMapping
    public Collection<Comment> createComment(@Argument String content,@Argument String postId){
        return commentService.createComment(content, postId);
    }

    // Retorna os comentários (comments) associados aos Post
    @SchemaMapping
    public Collection<Comment> comments(Post post){
        System.out.println("Comments");
        return commentService.findByPost(post.id());
    }
}
