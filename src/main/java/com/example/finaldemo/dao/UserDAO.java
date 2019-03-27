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
import java.util.ArrayList;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Nhat Anh
 * @email nhatanh2996@gmail.com
 */
public class UserDAO implements Serializable {

    public String addNewUser(UserDTO userDTO) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MysqlCon.getConnection();

            if (con != null) {
                String sql = "INSERT INTO user (id, username, password, name, address) VALUES (?,?, ?, ?, ?)";
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, userDTO.getId());
                pstm.setString(2, userDTO.getUsername());
                pstm.setString(3, userDTO.getPassword());
                pstm.setString(4, userDTO.getName());
                pstm.setString(5, userDTO.getAddress());

                pstm.executeUpdate();
                return "add_success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "add_failed_SQL_error";

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
        return "add_failed_SQL_error";

    }

    public String editUser(UserDTO userDTOEdit) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MysqlCon.getConnection();

            if (con != null) {
                String sql = "UPDATE  user SET name = ?, address = ? WHERE id = ?";
                pstm = con.prepareStatement(sql);
                pstm.setString(1, userDTOEdit.getName());
                pstm.setString(2, userDTOEdit.getAddress());
                pstm.setInt(3, userDTOEdit.getId());

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

    public String changePassword(int id, String newPassword) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MysqlCon.getConnection();

            if (con != null) {
                String sql = "UPDATE  user SET password = ? WHERE id = ?";
                pstm = con.prepareStatement(sql);
                pstm.setString(1, newPassword);
                pstm.setInt(2, id);

                pstm.executeUpdate();
                return "change_password_success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "change_password_failed";
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
                return "change_password_failed";
            }
        }
        return "change_password_failed";
    }

    public String removeUser(int userId) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {

            con = MysqlCon.getConnection();

            if (con != null) {
                String sql = "DELETE FROM  user  WHERE id = ?";
                pstm = con.prepareStatement(sql);

                pstm.setInt(1, userId);

                pstm.executeUpdate();
                return "remove_success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "remove_failed_SQL_error";
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
                return "remove_failed_SQL_error";
            }
        }
        return "remove_failed_SQL_error";

    }

    public UserDTO findUserByUsername(String username) {
        UserDTO resultUser = new UserDTO();
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
                    resultUser.setAddress(rs.getString("address"));
                    return resultUser;
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
        return null;
    }

    public List<UserDTO> findAll() {
        List<UserDTO> resultListUser = new ArrayList<>();
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
                    userDTO.setAddress(rs.getString("address"));

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
        UserDTO resultUser = new UserDTO();
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
                    resultUser.setAddress(rs.getString("address"));

                    return resultUser;
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
        return null;
    }

    public List<UserDTO> findAllUserByNameContains(String name) {
        List<UserDTO> resultListUser = new ArrayList<UserDTO>();
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
                    userDTO.setAddress(rs.getString("address"));
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
}
