package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
    public class Todo {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "title", nullable = false)
        private String title;

        @Column(name = "completed", nullable = false)
        private boolean completed;

        @Column(name="created_at",nullable = false,updatable = false)
        private LocalDateTime createdAt;

        public Todo() {
            this.completed = false;
            this.createdAt = LocalDateTime.now();
        }

        public Todo(String title) {
            this.title = title;
            this.completed = false;
            this.createdAt = LocalDateTime.now();
        }

        public Long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public boolean isCompleted() {
            return completed;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
}