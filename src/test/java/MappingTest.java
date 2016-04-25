

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hp.bean.Fans;
import com.hp.bean.Husband;
import com.hp.bean.Player;
import com.hp.bean.Stars;
import com.hp.bean.Team;
import com.hp.bean.Wife;


public class MappingTest {
	Configuration configuration=null;
	SessionFactory sessionFactory=null;
	Session session=null;
	Transaction transaction=null;
	@SuppressWarnings("deprecation")
	@Before
	public void before(){
		 configuration = new Configuration().configure();//初始化hibernate的配置文件
		 sessionFactory = configuration.buildSessionFactory();//创建sessionFactory
		 session = sessionFactory.openSession();//创建Session
		 transaction = session.beginTransaction();//开启事务
		
	}
	@Test
	public void onetomanysave(){
		Team team = new Team();
		team.setName("basketball");
		HashSet<Player> hash = new HashSet<Player>();
	    Player player = new Player();
	    player.setAge(22);
	    player.setName("yangyi");
	    Player play2=new Player();
	    play2.setAge(23);
	    play2.setName("wang");
	    hash.add(player);
	    hash.add(play2);
	    team.setPlayer(hash);
	    session.save(team);
	}
	//站在fans角度 存储
	@Test
	public void Fansmanytoone(){
		Fans fans = new Fans();
		fans.setGender("woman");
		fans.setName("qian");
		Stars star =new Stars();
		star.setName("TFBOYS");
		star.setGender("boy");
		fans.setStar(star);
        session.save(fans);		
	}
	//双向站在stars角度 存储(一对多)
		@Test
		public void Fansmanytoonestars(){
			Stars star= new Stars();
			star.setName("dengziqi");
			star.setGender("nv");
			Fans fans1 = new Fans();
			fans1.setGender("woman");
			fans1.setName("xiaohong");
			fans1.setStar(star);
			Fans fans2 = new Fans();
			fans2.setGender("man");
			fans2.setName("xiaoming");
			fans2.setStar(star);
			star.getFans().add(fans1);
			star.getFans().add(fans2);
			session.save(star);
		
		}
		//双向取出多的一方
		@Test
		public void getFans(){
			Fans fans = (Fans) session.load(Fans.class,1);
			fans.setGender("eee");
			fans.getStar().setName("yangyi");
		
		}
		//双向取出多的一方
				@Test
				public void getStar(){
					 Stars s = (Stars) session.get(Stars.class,1);
					 System.out.println(s.getName());
				
				}
				//gengixn
				//双向取出多的一方
				@Test
				public void update(){
					Fans fans  = (Fans) session.get(Fans.class, 15);
					fans.setGender("sss");
					fans.getStar().setName("yangyi");
				
				}
				@Test
				public void save222(){
					Husband husband = new Husband();
					husband.setName("yangyi");
				    Wife wife = new Wife();
				    wife.setName("gorgeous");
				    husband.setWife(wife);
				    session.save(husband);
				}
				@Test
				public void deleteFans(){
					/*Fans fans  = (Fans) session.load(Fans.class, 17);
					fans.setStar(null);//打破关联关系，防止级联删除
					session.delete(fans);*/
					session.createQuery("delete from Fans where id = 18").executeUpdate();
				}
				@Test
				public void deleteStars(){
					Stars star  = (Stars) session.load(Stars.class,6);
					star.setFans(null);//打破关联关系，防止级联删除
					session.delete(star);
					/*session.createQuery("delete from Fans where id = 18").executeUpdate();*/
				}
				@Test
				public void loadStars(){
					Wife wife  = (Wife) session.get(Wife.class,1);
					//Husband husband  = (Husband) session.get(Husband.class,1);
					
                   //Hibernate.initialize(star);
					//star.setFans(null);//打破关联关系，防止级联删除
					//session.delete(star);
					/*session.createQuery("delete from Fans where id = 18").executeUpdate();*/
				}
				@Test
				public void save(){
					/*Wife wife  = new Wife();
					wife.setName("gaojie");
					Husband husband = new Husband();
					husband.setName("yangyi");
					husband.setWife(wife);
					session.save(husband);*/
					
					Wife wife  = new Wife();
					wife.setName("gaojie");
					Husband husband = new Husband();
					husband.setName("yangyi");
					wife.setHusband(husband);
					session.save(wife);
					
					//Husband husband  = (Husband) session.get(Husband.class,1);
					
                   //Hibernate.initialize(star);
					//star.setFans(null);//打破关联关系，防止级联删除
					//session.delete(star);
					/*session.createQuery("delete from Fans where id = 18").executeUpdate();*/
				}
	/*	//测试一对多
	@Test
	public void onetomanysave(){
		Team team = new Team();
		team.setName("basketball");
		HashSet<Player> hash = new HashSet<Player>();
	    Player player = new Player();
	    player.setAge(22);
	    player.setName("yangyi");
	    Player play2=new Player();
	    play2.setAge(23);
	    play2.setName("wang");
	    hash.add(player);
	    hash.add(play2);
	    team.setPlayer(hash);
	    session.save(team);
	}
	@Test
	public void onetomanyquery(){
		Team team = new Team();
		//查询球队下面所有的队员
		team.setId(1);
	    List list = session.createQuery("from Team").list();
	    System.out.println(list);
	}
	@Test
	public void onetomanyupdate(){
		Team team = new Team();
		//查询球队下面所有的队员
		team.setId(1);
		team.setName("foot");
		HashSet<Player> hash1 = new HashSet<Player>();
	    Player player = new Player();
	    player.setAge(20);
	    player.setName("xiao");
	    team.setPlayer(hash1);
		session.update(team);
	  
	}
	
   //测试一对一
	@Test
	public void onetoone(){
		Wife wife = new Wife();
		wife.setName("gaojie");
		Husband husband = new Husband();
		husband.setName("yangyi");
		husband.setWife(wife);
		session.save(husband);
	}
  //测试多对一
	@Test
	public void manytoone() {
		
		BoyFriend boyfriend1 = new BoyFriend();
		BoyFriend boyfriend2 = new BoyFriend();	
		boyfriend1.setUsername("yangyi");
		boyfriend1.setPassword("123");
		boyfriend2.setUsername("yangyi111");
		boyfriend2.setPassword("123111");
		GirlFriend girlfriend = new GirlFriend();
		girlfriend.setUsername("gaojie");
		girlfriend.setPassword("123");
		boyfriend1.setGirlfriend(girlfriend);
		boyfriend2.setGirlfriend(girlfriend);
		session.save(boyfriend1);
		session.save(boyfriend2);
		
 	}
	@Test
	public void testget() {
		
		BoyFriend bf=(BoyFriend)session.get(BoyFriend.class, 1);
		System.out.println(bf.getGirlfriend().getUsername());
	
		
		
 	}*/
	@After
	public void after(){
		transaction.commit();
		session.close();
	}

}
