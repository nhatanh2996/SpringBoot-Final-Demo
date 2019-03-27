//package com.example.finaldemo.service;
//
////<editor-fold defaultstate="collapsed" desc="IMPORT">
//import com.example.finaldemo.dao.UserDAO;
//import com.example.finaldemo.dto.UserDTO;
//import org.mockito.Mockito;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import org.springframework.test.util.ReflectionTestUtils;
//import static org.testng.Assert.*;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
////</editor-fold>
//
///**
// *
// * @author Nguyen Duc Nhat Anh
// * @email nhatanh2996@gmail.com
// */
//public class UserServiceImplNGTest {
//
//    private UserServiceImpl userServiceImpl;
//    private UserDAO userDAO;
//    private UserDTO userDTO;
//
//    @BeforeClass
//    public void setUpClass() throws Exception {
//        userServiceImpl = new UserServiceImpl();
//        userDAO = Mockito.mock(UserDAO.class);
//        ReflectionTestUtils.setField(userServiceImpl, "userDAO", userDAO);
//
//    }
//
//    //<editor-fold defaultstate="collapsed" desc="TEST CREATE USER">
//    /*
//     * Number of test case: 
//     * 1/ existed user, userDAO.findUserById() return not null
//     * 2/
//     *
//     */
// /*
//     * Test case 1: existed user, userDAO.findUserById() return not null
//     */
//    @Test
//    public void testCreateUser_existUser_addFailedExistId() {
//        userDTO = Mockito.spy(UserDTO.class);
//        userDTO.setAddress("171dienbienphu");
//        userDTO.setName("nhatanh");
//        userDTO.setPassword("Anh@123");
//        userDTO.setUsername("nhatanh123");
//        userDTO.setId(123123123);
//
//        when(userDAO.findUserById(123123123)).thenReturn(userDTO);
//
//        String expResult = "add_failed_exist_id";
//        
//        String result = userServiceImpl.createUser(userDTO);
//
//        verify(userDAO).findUserById(123123123);
//        assertEquals(result, expResult);
//
//    }
//
//    /*
//     * Test case 2: existed user, userDAO.findUserByUsername(), return not null
//     */
////    @Test
////    public void testCreateUser_existUser_addFailedExistUsername() {
////        userDTO = Mockito.spy(UserDTO.class);
////        userDTO.setAddress("171dienbienphu");
////        userDTO.setName("nhatanh");
////        userDTO.setPassword("Anh@123");
////        userDTO.setUsername("asdasdsd");
////
////        when(userDAO.findUserById(Mockito.anyInt())).thenReturn(null);
////        when(userDAO.findUserByUsername(userDTO.getUsername())).thenReturn(userDTO);
////
////        String expResult = "add_failed_exist_username";
////          String result = userServiceImpl.createUser(userDTO);
////
////        verify(userDAO).findUserByUsername("nhatanh123");
////        assertEquals(result, expResult);
////
////    }
//
//    /**
//     * Test case 3: new user,userDAO.addNewUser(), return String "add_success"
//     */
////    @Test
////    public void testCreateUser_addSuccess() {
////        userDTO = Mockito.spy(UserDTO.class);
////        userDTO.setAddress("171dienbienphu");
////        userDTO.setName("nhatanh");
////        userDTO.setPassword("Anh@123");
////        userDTO.setUsername("asdasdsd");
////        userDTO.setId(123123123);
////
////        when(userDAO.findUserById(Mockito.anyInt())).thenReturn(null);
////        when(userDAO.findUserByUsername(userDTO.getUsername())).thenReturn(null);
////        
////
////        String expResult = "add_success";
////        String result = userServiceImpl.createUser(userDTO);
//////check userDAO).findUserByUsername() is run or is redundant(thừa thải)/ when both or more test case also return a value
////
////        assertEquals(result, expResult);
////
////    }
//
//    // </editor-fold>
//}
