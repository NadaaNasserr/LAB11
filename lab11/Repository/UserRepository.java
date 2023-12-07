package com.example.lab11.Repository;


import com.example.lab11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

  //  User findUserByUser_id(Integer id);
    User findUserByUserId(Integer id);

  @Query("select c from User c where c.username=?1 and c.password=?2")
  User pleasCheckPasswordAndUsername(String username, String password);

}