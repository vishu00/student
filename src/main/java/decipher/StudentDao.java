package decipher;

import decipher.config.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao
{



        public static int save(StudentRecord student) {
            int status=0;
            Connection connection = Dbconnection.getDbConnection();
            try{


                PreparedStatement ps=connection.prepareStatement("insert into Records(name,fatherName,age,standard)values (?,?,?,?)");

                ps.setString(1,student.getName());

                ps.setString(2,student.getFatherName());
                ps.setInt(3,student.getAge());
                ps.setInt(4,student.getStandard());

                status=ps.executeUpdate();//storing data into status

                //connection.close();

            }catch(Exception ex)
            {
                ex.printStackTrace();
            }

            finally
            {
                try
                {
                    connection.close();
                }
                catch (Exception e)
                {
                }
            }


            return status;
        }

        public static int update(StudentRecord student)  {
            int status=0;
            Connection connection= Dbconnection.getDbConnection();
            try{

                PreparedStatement ps=connection.prepareStatement("update Records set name=?,fathername=?,age=?,standard=? where id=?");

                ps.setString(1,student.getName());
                ps.setString(2,student.getFatherName());
                ps.setInt(3,student.getAge());
                ps.setInt(4,student.getStandard());
                ps.setInt(5,student.getId());

                status=ps.executeUpdate();

                //connection.close();
            }catch(Exception ex){ex.printStackTrace();}

            finally
            {
                try
                {
                    connection.close();

                }
                catch (Exception e)
                {
                }
            }

            return status;
        }

        public static int delete(int id)  {
            int status=0;
            Connection connection= Dbconnection.getDbConnection();
            try{

                PreparedStatement ps=connection.prepareStatement("delete from Records where id=?");

                ps.setInt(1,id);
                status=ps.executeUpdate();

                connection.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }

            finally
            {
                try
                {
                    connection.close();

                }
                catch (Exception e)
                {
                }
            }
            return status;
        }

        public static StudentRecord getStudentById(int id) {
            StudentRecord student=new StudentRecord();

            Connection connection= Dbconnection.getDbConnection();


            try{

                PreparedStatement ps=connection.prepareStatement("select * from Records where id=?");

                ps.setInt(1,id);
                ResultSet rs=ps.executeQuery();

                if(rs.next()){
                    student.setId(rs.getInt(1));
                    student.setName(rs.getString(2));
                    student.setFatherName(rs.getString(3));
                    student.setAge(rs.getInt(4));
                    student.setStandard(rs.getInt(5));
                }
                //connection.close();
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }

            finally
            {
                try
                {
                    connection.close();

                }
                catch (Exception e)
                {
                }
            }

            return  student;
        }

        public static List<StudentRecord> getAllStudents() {

            List<StudentRecord> list=new ArrayList<StudentRecord>();

            Connection connection= Dbconnection.getDbConnection();

            try{

                PreparedStatement ps=connection.prepareStatement("select * from Records");//change expected in all Statement object
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    StudentRecord student=new StudentRecord();
                    student.setId(rs.getInt(1));
                    student.setName(rs.getString(2));
                    student.setFatherName(rs.getString(3));
                    student.setAge(rs.getInt(4));
                    student.setStandard(rs.getInt(5));

                    list.add(student);
                }
                //connection.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }

            finally
            {
                try
                {
                    connection.close();

                }
                catch (Exception e)
                {
                }
            }

            return list;
        }
}


