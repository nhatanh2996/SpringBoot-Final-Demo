package com.example.finaldemo.dao;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.example.finaldemo.dto.UserDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.example.finaldemo.mysql_utils.MysqlCon;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Nhat Anh
 * @email nhatanh2996@gmail.com
 */
public class UserDAO implements Serializable {

    public boolean checkLogin(String username, String password) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MysqlCon.getConnection();

            if (con != null) {
                String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

                pstm = con.prepareStatement(sql);

                pstm.setString(1, username);
                pstm.setString(2, password);

                rs = pstm.executeQuery();

                if (rs.next()) {
                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String addNewUser(UserDTO userDTO) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MysqlCon.getConnection();

            if (con != null) {
                String sql = "INSERT INTO user (id, username, password, name) VALUES (?,?, ?, ?)";
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, userDTO.getId());
                pstm.setString(2, userDTO.getUsername());
                pstm.setString(3, userDTO.getPassword());
                pstm.setString(4, userDTO.getName());

                pstm.executeUpdate();
                return "add_success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "add_failed";

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String msg;
        return "add_failed";

    }

    public String editUser(UserDTO userDTOEdit) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MysqlCon.getConnection();

            if (con != null) {
                String sql = "UPDATE  user SET username = ?, password = ?, name = ? WHERE id = ?";
                pstm = con.prepareStatement(sql);
                pstm.setString(1, userDTOEdit.getUsername());
                pstm.setString(2, userDTOEdit.getPassword());
                pstm.setString(3, userDTOEdit.getName());
                pstm.setInt(4, userDTOEdit.getId());

                pstm.executeUpdate();
                return "edit_success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "edit_failed";
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "edit_failed";
            }
        }
        return "edit_failed";
    }

    public String removeUser(int userId) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            
            con = MysqlCon.getConnection();
            
            if (con != null) {
                String sql = "UPDATE  user  WHERE id = ?";
                pstm = con.prepareStatement(sql);

                pstm.setInt(1, userId);

                pstm.executeUpdate();
                return "remove_success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "remove_failed";
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "remove_failed";
            }
        }
        return "remove_failed";

    }

    public UserDTO findUserByUsername(String username) {
        UserDTO resultUser = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MysqlCon.getConnection();

            if (con != null) {
                String sql = "SELECT * FROM user WHERE username = ? ";

                pstm = con.prepareStatement(sql);

                pstm.setString(1, username);

                rs = pstm.executeQuery();

                if (rs.next()) {
//                    resultUser = (UserDTO) rs.getObject(0);
                    resultUser.setId(rs.getInt("id"));
                    resultUser.setUsername(rs.getString("username"));
                    resultUser.setPassword(rs.getString("password"));
                    resultUser.setName(rs.getString("name"));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return resultUser;
    }

    public List<UserDTO> findAll() {
        List<UserDTO> resultListUser = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MysqlCon.getConnection();

            if (con != null) {
                String sql = "SELECT * FROM user ";

                pstm = con.prepareStatement(sql);

                rs = pstm.executeQuery();

                while (rs.next()) {

                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(rs.getInt("id"));
                    userDTO.setUsername(rs.getString("username"));
                    userDTO.setPassword(rs.getString("password"));
                    userDTO.setName(rs.getString("name"));
                    resultListUser.add(userDTO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }

        }
        return resultListUser;
    }

    public UserDTO findUserById(int userId) {
        UserDTO resultUser = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MysqlCon.getConnection();

            if (con != null) {
                String sql = "SELECT * FROM user WHERE id = ? ";

                pstm = con.prepareStatement(sql);

                pstm.setInt(1, userId);

                rs = pstm.executeQuery();

                if (rs.next()) {
                    resultUser.setId(rs.getInt("id"));
                    resultUser.setUsername(rs.getString("username"));
                    resultUser.setPassword(rs.getString("password"));
                    resultUser.setName(rs.getString("name"));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return resultUser;
    }

    public List<UserDTO> findAllUserByNameContains(String name) {
        List<UserDTO> resultListUser = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MysqlCon.getConnection();

            if (con != null) {
                String sql = "SELECT * FROM user WHERE name LIKE %?%";

                pstm = con.prepareStatement(sql);
                pstm.setString(1, name);

                rs = pstm.executeQuery();

                while (rs.next()) {

                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(rs.getInt("id"));
                    userDTO.setUsername(rs.getString("username"));
                    userDTO.setPassword(rs.getString("password"));
                    userDTO.setName(rs.getString("name"));
                    resultListUser.add(userDTO);
                    System.out.println("nnnn");
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }

        }
        return resultListUser;
    }
}
