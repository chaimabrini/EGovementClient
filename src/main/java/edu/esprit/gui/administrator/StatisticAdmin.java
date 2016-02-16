package edu.esprit.gui.administrator;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleInsets;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.delegater.GestionEtablishmentDelegater;
import edu.esprit.domain.Claim;
import edu.esprit.domain.Employee;
import edu.esprit.domain.Etablishment;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class StatisticAdmin extends JFrame {

	private JPanel contentPane;
	private JLabel lblSignout;
	private JLabel lblProfile;
	private JLabel lblAgentperestab;
	private JLabel lblServiceperestab;
	private JLabel lblClaimofadmin;
	private JLabel lblBackgroundimage;
	
	List<Etablishment> etablishments;
	List<Claim> claims;
	JPanel panelstatistique;
	static Employee employee;
	Voice v;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticAdmin frame = new StatisticAdmin(employee);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static RadialGradientPaint createGradientPaint(Color c1, Color c2) {
        Point2D center = new Point2D.Float(0, 0);
        float radius = 200;
        float[] dist = {0.0f, 1.0f};
        return new RadialGradientPaint(center, radius, dist,
                new Color[] {c1, c2});
    }

	/**
	 * Create the frame.
	 */
	public StatisticAdmin(Employee e) {
		employee=e;
		VoiceManager vm = VoiceManager.getInstance();
		v = vm.getVoice("kevin16");
		v.allocate();
		
		claims = GestionClaimDelegater.doFindAllClaim();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSignout = new JLabel("");
		lblSignout.setBounds(856, 11, 35, 41);
		contentPane.add(lblSignout);
		
		lblProfile = new JLabel("");
		lblProfile.setBounds(812, 11, 41, 41);
		contentPane.add(lblProfile);
		
		lblAgentperestab = new JLabel("");
		lblAgentperestab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ee) {
				v.speak("Number of Agent Per Establishment");
				panelstatistique.removeAll();
				statistiqueAgentPerEstablishment();
				contentPane.add(lblBackgroundimage);
			}
			
		});
		lblAgentperestab.setBounds(17, 226, 118, 47);
		contentPane.add(lblAgentperestab);
		
		lblServiceperestab = new JLabel("");
		lblServiceperestab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				v.speak("Number of Service Per Establishment");
				panelstatistique.removeAll();
				statistiqueServicePerEstablishment();
				contentPane.add(lblBackgroundimage);
			}
		});
		lblServiceperestab.setBounds(17, 296, 118, 47);
		contentPane.add(lblServiceperestab);
		
		lblClaimofadmin = new JLabel("");
		lblClaimofadmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				v.speak("Claim Of Admin");
				panelstatistique.removeAll();
				statistiqueClaimOfAdmin();
				contentPane.add(lblBackgroundimage);
			}
		});
		lblClaimofadmin.setBounds(17, 365, 118, 54);
		contentPane.add(lblClaimofadmin);
		
		 panelstatistique= new JPanel();
		 panelstatistique.setBounds(187, 183, 658, 305);
		 
		 contentPane.add(panelstatistique);

			JLabel homeMenu = new JLabel("");
			homeMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					HomeAdmin homeA=new HomeAdmin(employee);
					setVisible(false);
					homeA.setVisible(true);
				}
			});
			homeMenu.setBounds(284, 42, 89, 37);
			contentPane.add(homeMenu);
			
			JLabel establishmentMenu = new JLabel("");
			establishmentMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			establishmentMenu.setBounds(377, 42, 72, 37);
			contentPane.add(establishmentMenu);
			JLabel categoryMenu = new JLabel("");
			categoryMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				   ManageCategories manageCat=new ManageCategories(employee);
				   setVisible(false);
				   manageCat.setVisible(true);
				}
			});
			categoryMenu.setBounds(453, 42, 80, 38);
			contentPane.add(categoryMenu);
			
			JLabel employeeMenu = new JLabel("");
			employeeMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GestionEmployees gestionEmp =new GestionEmployees(employee);
					setVisible(false);
					gestionEmp.setVisible(true);
				}
			});
			employeeMenu.setBounds(540, 42, 72, 37);
			contentPane.add(employeeMenu);
			
			JLabel statisticMenu = new JLabel("");
			statisticMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					StatisticAdmin statisticAdm=new StatisticAdmin(employee);
					setVisible(false);
					statisticAdm.setVisible(true);
				}
			});
			statisticMenu.setBounds(622, 42, 72, 37);
			contentPane.add(statisticMenu);
		 
		lblBackgroundimage = new JLabel("");
		lblBackgroundimage.setIcon(new ImageIcon(StatisticAdmin.class.getResource("/edu/esprit/image/statisticAdmin.jpg")));
		lblBackgroundimage.setBounds(0, 0, 893, 600);
		
		statistiqueAgentPerEstablishment();
		
		contentPane.add(lblBackgroundimage);
	}
	
	
	public DefaultPieDataset createAgentDataset(){
		etablishments = GestionEtablishmentDelegater.doFindAllEtablishment();
		
		DefaultPieDataset dataset = new DefaultPieDataset( );
		
		for(Etablishment e: etablishments){
			if(e.getListAgents().size()!=0){
				dataset.setValue(e.getName(), e.getListAgents().size());
			}
		}
		return dataset;
	}
	public DefaultPieDataset createClaimDataset(){
		
		DefaultPieDataset dataset = new DefaultPieDataset( );
		
		int nbrClaimDone=0;
		int nbrClaimUndone=0;
		
		for(Claim c: claims){
			if(c.getState().equals("true")){
				nbrClaimDone++;
			}else{
				nbrClaimUndone++;
			}
		}
		dataset.setValue("Claim Done", nbrClaimDone);
		dataset.setValue("Claim Undone", nbrClaimUndone);
		
		return dataset;
	}
	
	public DefaultPieDataset createServiceDataset(){
		etablishments = GestionEtablishmentDelegater.doFindAllEtablishment();
		
		DefaultPieDataset dataset = new DefaultPieDataset( );
		
		for(Etablishment e: etablishments){
			if(e.getListService().size()!=0){
				dataset.setValue(e.getName(), e.getListService().size());
			}
		}
		return dataset;
	}
	
	public void statistiqueAgentPerEstablishment(){
		DefaultPieDataset dataset=createAgentDataset();
		createCercle(dataset,"Number of Agent Per Establishment");
	}
	
	public void statistiqueServicePerEstablishment(){
		DefaultPieDataset dataset=createServiceDataset();
		createCercle(dataset,"Number of Service Per Establishment");
	}
	
	public void statistiqueClaimOfAdmin(){
		DefaultPieDataset dataset=createClaimDataset();
		createCercle(dataset,"Claims Of Admin");
	}
	
	public void createCercle(DefaultPieDataset dataset,String title){
		
	    JFreeChart chart = ChartFactory.createPieChart( 
	         title ,  // chart title                   
	         dataset ,         // data 
	         true ,            // include legend                   
	         true, 
	         false);
	      
	      	chart.setBackgroundPaint(new GradientPaint(new Point(0, 0), 
	                new Color(20, 20, 20), new Point(400, 200), Color.DARK_GRAY));

	        // customise the title position and font
	        TextTitle t = chart.getTitle();
	        t.setHorizontalAlignment(HorizontalAlignment.LEFT);
	        t.setPaint(new Color(240, 240, 240));
	        t.setFont(new Font("Arial", Font.BOLD, 20));

	        PiePlot plot =  (PiePlot) chart.getPlot(); 
	        plot.setBackgroundPaint(null);
	        plot.setInteriorGap(0.04);
	        plot.setOutlineVisible(false);
	     
	      
	   // use gradients and white borders for the section colours
	        plot.setBaseSectionOutlinePaint(Color.WHITE);
	        plot.setSectionOutlinesVisible(true);
	        plot.setBaseSectionOutlineStroke(new BasicStroke(2.0f));
	        
	        for(Etablishment e: etablishments){
	        	plot.setExplodePercent(e.getName(), 0.1);
		        
			}
	        plot.setExplodePercent("Claim Done", 0.1);
	        plot.setExplodePercent("Claim Undone", 0.1);
	        
	        
	     // customise the section label appearance DialogInput, Monospaced, Serif, or SansSerif
	        plot.setLabelFont(new Font("Serif", Font.BOLD, 14));
	        plot.setLabelLinkPaint(Color.WHITE);
	        plot.setLabelLinkStroke(new BasicStroke(2.0f));
	        plot.setLabelOutlineStroke(null);
	        plot.setLabelPaint(Color.WHITE);
	        plot.setLabelBackgroundPaint(null);
	        
	        // add a subtitle giving the data source
	        /*TextTitle source = new TextTitle("Source: http://www.bbc.co.uk/news/business-15489523", 
	                new Font("Courier New", Font.PLAIN, 12));
	        source.setPaint(Color.WHITE);
	        source.setPosition(RectangleEdge.BOTTOM);
	        source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
	        chart.addSubtitle(source);*/
	        
	        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
	        ChartPanel chartpanel = new ChartPanel(chart);
	        chartpanel.setMouseWheelEnabled(true);
	        chartpanel.setPreferredSize(new Dimension(480, 310));
	        
	        
	        panelstatistique.setLayout(new BorderLayout());
	        panelstatistique.add(chartpanel);
	        
	        //setContentPane(chartpanel);
	        contentPane.add(panelstatistique);
	        pack();
	        setBounds(100, 100, 909, 632);
	}
}
