package com.abc.work.mvc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import sun.misc.BASE64Encoder;
import javax.servlet.ServletException;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.List;

@org.springframework.stereotype.Controller
public class HomeController {

    @RequestMapping("/")
    public String getRegistrationPage(Model theModel){
        User user = new User();
        theModel.addAttribute("user",user);
        return "RegistrationForm";
    }

    @RequestMapping("/cust")
    public String getCustForm(Model theModel){
        Customer cust = new Customer();
        theModel.addAttribute("cust", cust);
        return "cust_form";
    }

    @RequestMapping("/cust_confirm")
    public String processCust(){

        return "cust_confirmation";
    }

    @RequestMapping("/studentData")
    public String getRegistrationDet(Model mod, @RequestParam("profile")CommonsMultipartFile file, @ModelAttribute("user") User user) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException, IOException, ServletException, Exception, HibernateException {
        String pass = user.getPassword();
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte []passarr = md.digest(pass.getBytes());
        BASE64Encoder bs = new BASE64Encoder();
        String dbpassword = bs.encode(passarr);
        user.setPassword(dbpassword);
        String path = "C:/Users/Henil/IdeaProjects/Project/web/WEB-INF/imgs/";
        String filename = path + file.getOriginalFilename();
        user.setProfile_url(filename);
        byte[] filearr = file.getBytes();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filename));
        bos.write(filearr);
        bos.flush();
        bos.close();
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        sf.close();
        /*
        String q = "select * from user where username = '" + username + "' or email = '" + email + "'";
        ResultSet rs = st.executeQuery(q);
        if(rs.next()){
            return "LoginForm";
        }
        else {
            String query = "INSERT INTO `user`(`username`, `email`, `password`, `dob`, `profile_url`) VALUES ('" + username + "','" + email + "','" + dbpassword + "', '" + date + "', '" + filename + "')";
            st.executeUpdate(query);
            return "student-data";
        }*/
        mod.addAttribute("user", user);
        return "student-data";
    }

    @RequestMapping("/login")
    public String getLoginPage(){
        return "LoginForm";
    }

    @RequestMapping("/loginCheck")
    public String checkLogin(Model mod, @RequestParam("user") String user, @RequestParam("pass") String pass) throws SQLException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte []passarr = md.digest(pass.getBytes());
        BASE64Encoder bs = new BASE64Encoder();
        String dbpassword = bs.encode(passarr);
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from User u where u.username = '"+ user +"' and u.password = '"+dbpassword+"'");
        List<User> l = query.list();
        User u = l.get(0);
        //System.out.println(u);

        if(u.getPassword().equals(dbpassword)){
            mod.addAttribute("user", u);
            //System.out.println(u.getPassword()+ "->" +dbpassword);
            sf.close();
            return "welcome";
        }
        else{
            mod.addAttribute("error", "Sorry something went wrong! Try again...");
            sf.close();
            return "LoginForm";
        }
    }
}