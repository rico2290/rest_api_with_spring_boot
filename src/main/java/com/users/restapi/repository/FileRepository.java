package com.users.restapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.users.restapi.models.FileUpload;

public interface FileRepository extends JpaRepository<FileUpload, Long> {
	
	FileUpload findById(long id);
	List<FileUpload> findByNameContaining(String name);
}
