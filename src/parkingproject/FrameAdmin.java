/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingproject;

/**
 *
 * @author metr
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class FrameAdmin extends JFrame implements ActionListener{
     
    Admin admin = new Admin();
    JFrame frame = new JFrame("Admin");
    JMenuBar mb = new JMenuBar();
    JMenu operator = new JMenu("About Operator");
    JMenu ShiftReport = new JMenu("ShiftReport");
    JMenuItem VShiftR = new JMenuItem("View ShiftReport");
    JMenu Admi = new JMenu("About Admin");
    JMenuItem AddAdmin = new JMenuItem("Add Admin");
    JMenuItem VAdmin = new JMenuItem("View Admin");
    JMenuItem addoperator = new JMenuItem("Add Operator");
    JMenuItem UpdateOperator = new JMenuItem("Update Operator");
    JMenuItem ViewOperator = new JMenuItem("view Operators");
    JMenuItem DeleteOperator = new JMenuItem("Delete Operator");
    JMenuItem UpdateEmail_op = new JMenuItem("Update Email");
    JMenuItem UpdatePhone_op = new JMenuItem("Update PhoneNumber");
    JMenu Slots = new JMenu(" Slots");
    JMenuItem VSlots = new JMenuItem("View Slots");
    JMenuItem AddSlotts = new JMenuItem("Add Slots");
    JMenu CustomerTicket = new JMenu("About Cusotmer And Ticket");
    JMenuItem CT = new JMenuItem("Info about Customer and Ticket");
    JMenu LogOut = new JMenu("Logout");
        JMenuItem LOGOUT = new JMenuItem("Log Out");
    
     JPanel paddop;//add operator
    JLabel IdD;
    JLabel nam;
    JLabel passwor;
    JLabel emai;
    JLabel phon,P,S;
    JTextField tidd;
    JTextField tnam;
    JTextField tpas;
    JTextField tphon;
    JTextField temai;
    JLabel title1;
    JButton baddop; 
    JTable table;
    //
    
    JButton delete = new JButton("Delete"); //Delete operator
    JLabel iD ;
    JTextField tid_op ;
    JLabel Deleteop;
       JPanel addop;

  //  
       JButton AddSlot = new JButton("Add"); // add slots
    JLabel id_s ;
    JTextField tid_s ;
    JLabel adds;
       JPanel addslots;
//
     JPanel c; //add admin
     JLabel title; 
     JLabel name; 
     JTextField tname; 
     JLabel email;
     JTextField temail; 
     JLabel id; 
     JTextField tid; 
     JLabel password;
     JPasswordField tpass;
     JLabel phone; 
     JTextField tphone; 
     JButton ADD;
     
     
       JComboBox Update;//update email or phone
        JLabel title2,choose,idopp;
        JTextField tch;
        JButton up;
        JPanel pupdate;
        JTextField tid1;
     
        // JTable TVAdmin;//view admin
               JPanel VA;
    
//
             //  JTable TVO;//view operator
              JPanel VO;
              //
            //  JTable TSlot;
              JPanel VSlot;
    //
           //    JTable TSR;//View Shift Report
              JPanel VSR;
              //
           //    JTable TCT;//view info of customer and ticket
              JPanel VCT;
              JScrollPane scrollpane=new JScrollPane();
     public FrameAdmin() {
        frame.setSize(800, 560);
        frame.setVisible(true);
        mb.add(Admi);
        mb.add(operator);
        mb.add(Slots);
        mb.add(ShiftReport);
        mb.add(CustomerTicket);
        mb.add(LogOut);
        operator.add(addoperator);
        operator.add(UpdateOperator);
        operator.add(ViewOperator);
        operator.add(DeleteOperator);
        //operator.add(UpdateEmail_op);
        //operator.add(UpdatePhone_op);
        Slots.add(AddSlotts);
        Slots.add(VSlots);
        Admi.add(AddAdmin);
        Admi.add(VAdmin);
        ShiftReport.add(VShiftR);
        CustomerTicket.add(CT);
        LogOut.add(LOGOUT);
      //Delete operatoe
     //  addop= getContentPane();
   

        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JPanel addadmin = new JPanel();// add admin
        //frame.add(addadmin);
        // addadmin.setBounds(40,80,200,200);    
   
        c=new JPanel();//add admin
        c.setLayout(null);
        c.setVisible(false);
        
        title = new JLabel("Add Admin"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(350, 30); 
        c.add(title);
  
        id = new JLabel("ID"); 
        id.setFont(new Font("Arial", Font.PLAIN, 20)); 
        id.setSize(100, 20); 
        id.setLocation(200, 100); 
        c.add(id); 
  
        tid = new JTextField(); 
        tid.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tid.setSize(190, 20); 
        tid.setLocation(300, 100); 
        c.add(tid); 
  
         name = new JLabel("Name"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(100, 20); 
        name.setLocation(200, 150); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(190, 20); 
        tname.setLocation(300, 150); 
        c.add(tname); 
        
         password = new JLabel("Password"); 
        password.setFont(new Font("Arial", Font.PLAIN, 20)); 
        password.setSize(100, 20); 
        password.setLocation(200, 200); 
        c.add(password); 
 
        tpass = new JPasswordField();
        tpass.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tpass.setSize(190, 20); 
        tpass.setLocation(300, 200); 
        c.add(tpass);
        
         email = new JLabel("Email"); 
        email.setFont(new Font("Arial", Font.PLAIN, 20)); 
        email.setSize(100, 20); 
        email.setLocation(200, 250); 
        c.add(email); 
  
        temail = new JTextField(); 
        temail.setFont(new Font("Arial", Font.PLAIN, 15)); 
        temail.setSize(190, 20); 
        temail.setLocation(300, 250); 
        c.add(temail); 
        
         phone = new JLabel("Phone"); 
       phone.setFont(new Font("Arial", Font.PLAIN, 20)); 
        phone.setSize(100, 20); 
        phone.setLocation(200, 300); 
        c.add(phone); 
  
        tphone = new JTextField(); 
        tphone.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tphone.setSize(190, 20); 
        tphone.setLocation(300, 300); 
        c.add(tphone); 
        
          ADD = new JButton("ADD");
           ADD.setSize(70,20);
           ADD.setLocation(320, 350);      
           c.add(ADD);
           
        P = new JLabel ("must have at least 6 character");
        P.setFont(new Font("Arial", Font.PLAIN, 10)); 
        P.setSize(300, 20); 
        P.setLocation(500, 200); 
        c.add(P);

        frame.add(c);   ///////////////////////mo5talefaaaa
        c.setVisible(true); ///////////////////////mo5talefaaaa
   
   // 
   
   
   
         paddop=new JPanel();//add Operator
         paddop.setLayout(null);
       //  paddop.setVisible(false);    //makanetsh mawgoda         /////////////////mo5talefaaaaa
        title1 = new JLabel("Add Operator"); 
        title1.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title1.setSize(300, 30); 
        title1.setLocation(350, 30); 
         
  
        IdD = new JLabel("ID"); 
        IdD.setFont(new Font("Arial", Font.PLAIN, 20)); 
        IdD.setSize(100, 20); 
        IdD.setLocation(200, 100); 
        paddop.add(IdD); 
  
        tidd = new JTextField(); 
        tidd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tidd.setSize(190, 20); 
        tidd.setLocation(300, 100); 
        paddop.add(tidd); 
  
         nam = new JLabel("Name"); 
        nam.setFont(new Font("Arial", Font.PLAIN, 20)); 
        nam.setSize(100, 20); 
        nam.setLocation(200, 150); 
        paddop.add(nam); 
  
        tnam = new JTextField(); 
        tnam.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tnam.setSize(190, 20); 
        tnam.setLocation(300, 150); 
        paddop.add(tnam); 
        
         passwor = new JLabel("Password"); 
        passwor.setFont(new Font("Arial", Font.PLAIN, 20)); 
        passwor.setSize(100, 20); 
        passwor.setLocation(200, 200); 
        paddop.add(passwor); 
 
        tpas = new JPasswordField();
        tpas.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tpas.setSize(190, 20); 
        tpas.setLocation(300, 200); 
        paddop.add(tpas);
        
         emai = new JLabel("Email"); 
        emai.setFont(new Font("Arial", Font.PLAIN, 20)); 
        emai.setSize(100, 20); 
        emai.setLocation(200, 250); 
        paddop.add(emai); 
  
        temai = new JTextField(); 
        temai.setFont(new Font("Arial", Font.PLAIN, 15)); 
        temai.setSize(190, 20); 
        temai.setLocation(300, 250); 
        paddop.add(temai); 
        
         phon = new JLabel("Phone"); 
       phon.setFont(new Font("Arial", Font.PLAIN, 20)); 
        phon.setSize(100, 20); 
        phon.setLocation(200, 300); 
        paddop.add(phon); 
  
        tphon = new JTextField(); 
        tphon.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tphon.setSize(190, 20); 
        tphon.setLocation(300, 300); 
        paddop.add(tphon); 
        
        baddop=new JButton("Add");
         baddop.setSize(70,20);
         baddop.setLocation(320, 350);
         paddop.add(baddop);
         paddop.add(P);
        //frame.add(paddop);
      
        paddop.setVisible(false);
   
         /////////////////////////////////
          addop=new JPanel();//delete operator
     addop.setLayout(null);
        addop.setVisible(false);
               
         Deleteop=new JLabel("Delete Operator");
        Deleteop.setFont(new Font("Serif", Font.BOLD, 25));
        Deleteop.setBounds(300,10,200,30);
        addop.add(Deleteop);
        
        iD= new JLabel("The ID Of Operator:");
         iD.setLocation(200,150);
         iD.setSize(150,30);
        addop.add(iD);
        
        tid_op=new JTextField();
        tid_op.setSize(150,30);
        tid_op.setLocation(350,150);
        addop.add(tid_op);
        
        delete=new JButton("Delete");
        delete.setSize( 100, 30);
        delete.setLocation(300, 210);
        addop.add(delete);
       
        
///////////////////////////////
        
          
          addslots=new JPanel();//add slots
     addslots.setLayout(null);
        addslots.setVisible(false);
               
        adds=new JLabel("Add Slot");
        adds.setFont(new Font("Serif", Font.BOLD, 25));
         adds.setSize(300, 30); 
         adds.setLocation(350, 30); 
        addslots.add(adds);
        
        id_s= new JLabel("Description:");
         id_s.setLocation(200,150);
         id_s.setSize(150,30);
        addslots.add(id_s);
        
        tid_s=new JTextField();
        tid_s.setSize(150,30);
        tid_s.setLocation(350,150);
        addslots.add(tid_s);
        
        S=new  JLabel("EX:A1");
          S.setFont(new Font("Arial", Font.PLAIN, 15)); 
         S.setSize(150,30);
        S.setLocation(520,150);
        addslots.add(S);
        
        
        AddSlot=new JButton("Add");
        AddSlot.setSize( 100, 30);
        AddSlot.setLocation(300, 210);
        addslots.add(AddSlot);
        
        
         
      //
       pupdate=new JPanel(); // update email or phone
               pupdate.setVisible(true);  //hya kanet true          //////////////////////////////mo5talefaaaaaaaaaaa
pupdate.setLayout(null);
       String [] chos = {"Email","Phone"};
       Update=new JComboBox(chos);
       title2= new JLabel("Update Operator");
        title2.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title2.setSize(300, 30); 
        title2.setLocation(300, 30); 
        pupdate.add(title2);
        
        choose=new JLabel("Choose");
        choose.setFont(new Font("Arial", Font.PLAIN, 20)); 
        choose.setSize(100, 30); 
        choose.setLocation(200, 250); 
        pupdate.add(choose); 
        
        Update.setFont(new Font("Arial", Font.PLAIN, 20)); 
        Update.setSize(120, 30); 
        Update.setLocation(300, 250); 
        pupdate.add(Update); 
        
        tch = new JTextField(); 
        tch.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tch.setSize(190, 30); 
        tch.setLocation(440, 250); 
        pupdate.add(tch);
        
        idopp=new JLabel("Id Of Operator");
        idopp.setFont(new Font("Arial", Font.PLAIN, 20)); 
        idopp.setSize(150, 30); 
        idopp.setLocation(200, 200); 
        pupdate.add(idopp); 
         tid1 = new JTextField(); 
        tid1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tid1.setSize(190, 30); 
        tid1.setLocation(440, 200); 
        pupdate.add(tid1);
        up=new JButton("Update");
         //up.setFont(new Font("Arial", Font.PLAIN, 15)); 
        up.setSize(100, 30); 
        up.setLocation(320, 290); 
        pupdate.add(up);
pupdate.setVisible(false);                  //////////////////////mo5talefaaaaaaaaaaaaaaaaaaaa  kanet comment
      ///*
      
       VA=new JPanel();//view admin
              //     VA.setLayout(null);
                   VA.setVisible(false);
                  
                 
      
      //
                   VO=new JPanel();//view operator
                 //  VO.setLayout(null);
                   VO.setVisible(false);
                  
                   //
                   VSlot=new JPanel();//view Slot
                  // VSlot.setLayout(null);
                   VSlot.setVisible(false);
                   
                   //frame.add(VSlot);
                   //
                   
                   VSR=new JPanel();//view ShiftReport
                 //  VSR.setLayout(null);
                   VSR.setVisible(false);
                  
                   
                   //
                   VCT=new JPanel();//view info of customer and ticket
               //    VCT.setLayout(null);
                   VCT.setVisible(false);
                 
                   //
                   AddAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         
                            // c.add(title);
                            
                            addop.setVisible(false);
                            addslots.setVisible(false);
                            pupdate.setVisible(false);
                            paddop.setVisible(false);
                            VA.setVisible(false);
                            VO.setVisible(false);
                            VCT.setVisible(false); 
                            VSlot.setVisible(false);
                            VSR.setVisible(false);
                            pupdate.setVisible(false);
                            c.add(P);
                            frame.add(c);
                            c.setVisible(true);
                           // c.setVisible(true);
                            
                              

            }});
            addoperator.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                paddop.add(title1);
                   addop.setVisible(false); //delete operator
                c.setVisible(false); // add admin
                addslots.setVisible(false); // add operator
                VA.setVisible(false);
                VO.setVisible(false);
                VCT.setVisible(false);
                VSR.setVisible(false);
                VSlot.setVisible(false);
                 pupdate.setVisible(false);  //////////////////////////mo5talefaaaa makanetsh mawgodaaaa
                 
                frame.add(paddop);
                paddop.setVisible(true);
                  }
        
        } );
                  DeleteOperator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 addslots.setVisible(false); 
                c.setVisible(false); // add admin
                paddop.setVisible(false); // add operator
                pupdate.setVisible(false);
                VA.setVisible(false);
                VO.setVisible(false);
                VCT.setVisible(false);
                VSR.setVisible(false);
                VSlot.setVisible(false);
              frame.add(addop);
              addop.setVisible(true);

          
                

            }
        });
                   AddSlotts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 addop.setVisible(false); //delete operator
                c.setVisible(false); // add admin
                paddop.setVisible(false); // add operator
                VA.setVisible(false);
                VO.setVisible(false);
                VCT.setVisible(false);
                VSR.setVisible(false);
                VSlot.setVisible(false); 
                pupdate.setVisible(false);
               frame.add(addslots);
               addslots.setVisible(true);
            }
        });
                   
                   UpdateOperator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               addop.setVisible(false); //delete operator
                c.setVisible(false); // add admin
                paddop.setVisible(false); // add operator
                VA.setVisible(false);
                VO.setVisible(false);
                VCT.setVisible(false);
                VSR.setVisible(false);
                VSlot.setVisible(false);
                addslots.setVisible(false);
               frame.add(pupdate);
               pupdate.setVisible(true);
            }
        });
            
        
 
          
 VShiftR.addActionListener(new ActionListener() { // View Shift Report
            @Override
            public void actionPerformed(ActionEvent e) {
                VA.setVisible(false);
               VO.setVisible(false);
                VCT.setVisible(false);
               VSlot.setVisible(false);
                addop.setVisible(false);
                addslots.setVisible(false);
                c.setVisible(false);
                paddop.setVisible(false);
                pupdate.setVisible(false);
                table=admin.ViewShiftReports();
                   table.setPreferredScrollableViewportSize(table.getPreferredSize());
                   table.setFillsViewportHeight(true);
                   table.setDefaultEditor(Object.class, null);
                   scrollpane.getViewport ().add (table);
                   VSR.add(scrollpane);
                  // VSR.add(table);
                  VSR.setVisible(true);
                frame.add(VSR);
               // VSR.setVisible(true);
            }
        });
        VAdmin.addActionListener(new ActionListener() { // view Admin
            @Override
            public void actionPerformed(ActionEvent e) {
                 VSR.setVisible(false);
                VO.setVisible(false);
                VCT.setVisible(false);
                VSlot.setVisible(false);
                addop.setVisible(false);
                addslots.setVisible(false);
                c.setVisible(false);
                paddop.setVisible(false);
                pupdate.setVisible(false);
                table=admin.viewAdmins();
                   table.setPreferredScrollableViewportSize(table.getPreferredSize());
                   table.setFillsViewportHeight(true);
                   table.setDefaultEditor(Object.class, null);
                  // scrollpane=new  JScrollPane(table);
                   scrollpane.getViewport ().add (table);
                   VA.add(scrollpane);
                  // VA.add(table);
                  VA.setVisible(true);
                frame.add(VA);
                //VA.setVisible(true);
            }
        });
       
        
              
            CT.addActionListener(new ActionListener() { // view INfo of Customer and ticket
            @Override
            public void actionPerformed(ActionEvent e) {
               VA.setVisible(false);
                VO.setVisible(false);
                VSR.setVisible(false);
                VSlot.setVisible(false);
                addop.setVisible(false);
                addslots.setVisible(false);
                c.setVisible(false);
                paddop.setVisible(false);
                pupdate.setVisible(false);
                table=admin.InfoOfCustemersAndTickets();
                   table.setPreferredScrollableViewportSize(table.getPreferredSize());
                   table.setFillsViewportHeight(true);
                   table.setDefaultEditor(Object.class, null);
                    scrollpane.getViewport ().add (table);
                    VCT.add(scrollpane);
                   VCT.setVisible(true);
                frame.add(VCT);
               // VCT.setVisible(true);
            }
        } );
          
      
                  VSlots.addActionListener(new ActionListener() { // view slots
            @Override
            public void actionPerformed(ActionEvent e) {
                VA.setVisible(false);
                VO.setVisible(false);
                VSR.setVisible(false);
                VCT.setVisible(false);
                addop.setVisible(false);
                addslots.setVisible(false);
                c.setVisible(false);
                paddop.setVisible(false);
                pupdate.setVisible(false);
                table=admin.viewSpots();
                   table.setPreferredScrollableViewportSize(table.getPreferredSize());
                   table.setFillsViewportHeight(true);
                   table.setDefaultEditor(Object.class, null);
                   scrollpane.getViewport ().add (table);
                   VSlot.add(scrollpane);
                   VSlot.setVisible(true);
                 //  VSlot.add(table);
                frame.add(VSlot);
                //VSlot.setVisible(true);
            }
        });
                   
    ViewOperator.addActionListener(new ActionListener() { //view operator
            @Override
            public void actionPerformed(ActionEvent e) {
                VA.setVisible(false);
                VSlot.setVisible(false);
                VSR.setVisible(false);
                VCT.setVisible(false);
                addop.setVisible(false);
                addslots.setVisible(false);
                c.setVisible(false);
                paddop.setVisible(false);
                pupdate.setVisible(false);
                table=admin.viewOperators();
                   table.setPreferredScrollableViewportSize(table.getPreferredSize());
                   table.setFillsViewportHeight(true);
                   table.setDefaultEditor(Object.class, null);
                   scrollpane.getViewport ().add (table);
                   VO.add(scrollpane);
                   VO.setVisible(true);
                 //  VO.add(table);
                 
                frame.add(VO);
                //VO.setVisible(true);
            }
        });
   
//
       ADD.addActionListener(new ActionListener(){ // button add admin
               @Override
                public void actionPerformed(ActionEvent ae) {
                   String iid  = tid.getText().trim();
                   String pass=tpass.getText();
                   String emaill=temail.getText().trim();
                   String namee = tname.getText().trim();
                   String phonee= tphone.getText().trim();
                    
                    boolean incorrect = true,checkphone=false;
                    while(incorrect){
                      try{
                        Integer.parseInt(iid);
                        incorrect = false;
                      }
                       catch(NumberFormatException formate){
                          iid=JOptionPane.showInputDialog("Invalid input.please enter a number without spaces");
                       }

                      } 
                    
                    
                    Boolean checkpass=validpassword(pass);
                      while(!checkpass){
                       pass=JOptionPane.showInputDialog("Invalid Password: password length must have at least 6 character,1 digit,1 upper case character,and @,$,#,&,%,^");
                      checkpass=validpassword(pass);
                     }
               
               
                    Boolean checkemail=validemail(emaill);
                      while(!checkemail){
                         emaill=JOptionPane.showInputDialog("Invalid input:Please enter valid email");
                         checkemail=validemail(emaill);
                      }
               
               
                    checkphone=validPhone(phonee);
                     while(!checkphone){                      
                          phonee=JOptionPane.showInputDialog("Invalid input.please enter phone number of 11 digits");
                          checkphone=validPhone(phonee);
                      } 
                    
    if(iid.isEmpty() || (iid.trim().isEmpty()) || pass.isEmpty() || (pass.trim().isEmpty()) ||emaill.isEmpty() || (emaill.trim().isEmpty())||namee.isEmpty() || (namee.trim().isEmpty())|| phonee.isEmpty() || (phonee.trim().isEmpty())) {
                                    JOptionPane.showMessageDialog(ADD, "Please Enter All Information","Add Admin",JOptionPane.PLAIN_MESSAGE);
                    }else if (admin.AddAdmins(Integer.valueOf(iid), namee, emaill, pass, phonee)==1){
                                    JOptionPane.showMessageDialog(ADD, "Successful" ,"Add Admin",JOptionPane.PLAIN_MESSAGE );
                    }else{
                                     JOptionPane.showMessageDialog(ADD, "Error ID already exist" ,"Add Admin",JOptionPane.ERROR_MESSAGE);

                    }
                   tid.setText("");
                   tpass.setText("");
                   temail.setText("");
                   tname.setText("");
                   tphone.setText("");
                }
                    
            }
             );
       

              baddop.addActionListener(new ActionListener(){ // button add operator
                @Override
                public void actionPerformed(ActionEvent ae) {
                   String Iid  = tidd.getText().trim();
                   String Pass=tpas.getText();
                   String Emaill=temai.getText().trim();
                   String Namee = tnam.getText().trim();
                   String Phonee= tphon.getText().trim();
                    boolean incorrect = true,checkphone=false;
                    while(incorrect){
                        try{
                          Integer.parseInt(Iid);
                          incorrect = false;
                        }
                         catch(NumberFormatException formate){
                           Iid=JOptionPane.showInputDialog("Invalid input.please enter a number without spaces");
                        }

                    }
                    
                     Boolean checkpass=validpassword(Pass);
                      while(!checkpass){
                       Pass=JOptionPane.showInputDialog("Invalid Password: password length must have at least 6 character,1 digit,1 upper case character,and @,$,#,&,%,^");
                      checkpass=validpassword(Pass);
                     }
                      
                    Boolean checkemail=validemail(Emaill);
                   while(!checkemail){
                    Emaill=JOptionPane.showInputDialog("Invalid input.please enter valid email");
                    checkemail=validemail(Emaill);
                   }
                   
                    checkphone=validPhone(Phonee);
                     while(!checkphone){                      
                          Phonee=JOptionPane.showInputDialog("Invalid input.please enter phone number of 7 digits");
                          checkphone=validPhone(Phonee);
                      } 
                     
     if(Iid.isEmpty() || (Iid.trim().isEmpty()) || Pass.isEmpty() || (Pass.trim().isEmpty()) || Emaill.isEmpty() || (Emaill.trim().isEmpty())||Namee.isEmpty() || (Namee.trim().isEmpty())|| Phonee.isEmpty() || (Phonee.trim().isEmpty())) {
                                    JOptionPane.showMessageDialog(baddop, "Please Enter All Information","Add Operator",JOptionPane.PLAIN_MESSAGE);
                    }else if (admin.AddOperator(Integer.valueOf(Iid), Namee, Emaill, Pass, Phonee)==1){
                                    JOptionPane.showMessageDialog(baddop, "Successful" ,"Add Operator",JOptionPane.PLAIN_MESSAGE );
                    }else{
                                     JOptionPane.showMessageDialog(baddop, "Error" ,"Add Operator",JOptionPane.ERROR_MESSAGE);

                    }
                   tidd.setText("");
                   tpas.setText("");
                   temai.setText("");
                   tnam.setText("");
                   tphon.setText("");
                
                }
                    
            }
                    );
             delete.addActionListener(new ActionListener(){ //button delete operator
                 @Override
                public void actionPerformed(ActionEvent ae) {
                   String id1 = tid_op.getText().trim();
                    boolean incorrect = true;
                    while(incorrect){
                      try{
                       Integer.parseInt(id1);
                       incorrect = false;
                      }
                      catch(NumberFormatException formate){
                      id1=JOptionPane.showInputDialog("Invalid input.please enter a number without spaces");
                      }

        } 
                    if(id1.isEmpty() || (id1.trim().isEmpty())) {
                JOptionPane.showMessageDialog(delete, "Please Enter the ID","Delete Operator",JOptionPane.PLAIN_MESSAGE);
            }else if(admin.DeleteOperator(Integer.valueOf(id1))==1){
            JOptionPane.showMessageDialog(delete, "Successful" ,"Delete Operator",JOptionPane.PLAIN_MESSAGE );
            }else{
                 JOptionPane.showMessageDialog(delete, "Error ID does not exist" ,"Delete Operator",JOptionPane.ERROR_MESSAGE);
            }
              tid_op.setText("");
                
                }
            
            } );
             
       
             AddSlot.addActionListener(new ActionListener(){ // button add slots
                @Override
                public void actionPerformed(ActionEvent ae) {
                   String iD  = tid_s.getText().trim();
                    boolean incorrect = true;
                    while(incorrect){
                       try{
                         Integer.parseInt(iD);
                        incorrect = false;
                       }
                       catch(NumberFormatException formate){
                       iD=JOptionPane.showInputDialog("Invalid input.please enter a number without spaces");
                       }

                       } 
                    if(iD.isEmpty() || (iD.trim().isEmpty()) ) {
                        JOptionPane.showMessageDialog(AddSlot, "Please Enter the Description","Add Slot",JOptionPane.PLAIN_MESSAGE);
                    }else {
                        admin.AddSpot(iD);
                        JOptionPane.showMessageDialog(AddSlot, "Successful" ,"Add Slot",JOptionPane.PLAIN_MESSAGE );
                    }
                    tid_s.setText("");

            }
                     
            }
             );
             
             
              up.addActionListener(new ActionListener(){ // button update operator
                @Override
                public void actionPerformed(ActionEvent ae) {
                   String iidd = tid1.getText().trim();
                   String Ep  = tch.getText().trim();
                    boolean incorrect = true;
                    while(incorrect){
                      try{
                        Integer.parseInt(iidd);
                        incorrect = false;
                      }
                      catch(NumberFormatException formate){
                      iidd=JOptionPane.showInputDialog("Invalid input.please enter a number without spaces");
                      }

                    } 
                  if(Ep.isEmpty() || (Ep.trim().isEmpty()) || iidd.isEmpty() || (iidd.trim().isEmpty()) ){
                       
                      JOptionPane.showMessageDialog(up, "Please Enter All Information" ,"Update Operator",JOptionPane.PLAIN_MESSAGE );
                  }else{ 
                   if(admin.UpdateOperator(Integer.valueOf(iidd))==1){
                   String comvalue=(String)Update.getSelectedItem();
                    if(comvalue=="Email" && ! Ep.isEmpty()&& !(Ep.trim().isEmpty()) ) {
                        admin.updateEmail(Ep, Integer.valueOf(iidd));
                        JOptionPane.showMessageDialog(up, "Successful","Update Operator",JOptionPane.PLAIN_MESSAGE);
                    }else if (comvalue=="Phone" && ! Ep.isEmpty()&& !(Ep.trim().isEmpty())){
                        admin.updatePhone(Ep, Integer.valueOf(iidd));
                        JOptionPane.showMessageDialog(up, "Successful" ,"Update Operator",JOptionPane.PLAIN_MESSAGE );
                    }

                    }
            }
                tid1.setText("");
                tch.setText("");
                }
                     
            });
              ///
              
              LOGOUT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                             admin.Logout();
                             frame.setVisible(false);
                             new BackgroundImageJFrame();
                   }});
                       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
}
      public static boolean validPhone(String phonee){
          return phonee.charAt(0)=='0' && phonee.charAt(1)=='1' && phonee.length()==11 && phonee.matches("[0-9]+");
      } 
      public static Boolean validemail(String email){
           String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
           
             return Pattern.matches(regex,email);
      }
      
     public static  Boolean validpassword(String password){
           String PASSWORD_REgex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{6,10}$";
           Boolean password_pattern = Pattern.matches(PASSWORD_REgex, password);
       
       return password_pattern;
}
     
}
