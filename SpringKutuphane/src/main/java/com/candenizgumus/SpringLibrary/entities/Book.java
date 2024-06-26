package com.candenizgumus.SpringLibrary.entities;

import com.candenizgumus.SpringLibrary.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblbook")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String authorname;
    Integer pagenumber;
    String genre;
    @Enumerated(EnumType.STRING)
    Status status;
    Double price;

}
