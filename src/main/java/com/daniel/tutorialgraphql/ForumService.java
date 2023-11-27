package com.daniel.tutorialgraphql;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
class PostService {

    // Para salvar em memória
    Map<String, Post> posts = new HashMap<>();

    // Cria Post
    Collection<Post> createPost(String content){
        
        var newPost = new Post(UUID.randomUUID().toString(), content);

        posts.put(newPost.id(), newPost);

        return posts.values();
    }


    // Busca Post por id
    Post postById(String id){
        return posts.get(id);
    }
    
}


@Service
class CommentService {
    // Para salvar em memória
    Map<String, Comment> comments = new HashMap<>();

    // Cria Comment
    Collection<Comment> createComment(String content, String postId){
        
        var newComment = new Comment(UUID.randomUUID().toString(), content, postId);

        comments.put(newComment.id(), newComment);

        return comments.values();
    }

    public Collection<Comment> findByPost(String id) {
        return comments.values().stream().filter(comment -> comment.postId().equals(id)).toList();
    }

}
