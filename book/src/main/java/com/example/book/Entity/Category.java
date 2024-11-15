package com.example.book.Entity;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name ="category")
public class Category {
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID )
    private UUID id;

    @Column(nullable = false )
    private String name;

    @Column(nullable = false )
    private String description;
    
    @OneToMany(mappedBy = "category")
    private List<Book> books;
}
