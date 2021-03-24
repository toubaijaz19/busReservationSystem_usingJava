/**
 * 
 */
package busReservationSystem;

/**
 * 
 *
 */
import java.io.*;
import java.util.Vector;
public class BusReservation {

	public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int total=0;
    String email,contact,user,password,yn,search,again,choice;
    int destNo=0,y=1,z=0,end=0;
    int available[] = new int[6];
    int ticketI[][] = new int [100][3];
    String ticketS[][] = new String[100][3];
    double ticketD[][] = new double [100][3];
    double pay[] = new double[20];
    double change[] = new double[20];
    Display customer=new Display();
    Vector<Customer> v = new Vector<Customer>(20);
   for(int i=0;i<20;i++) 
   
   {
	   v.add(new Customer());
   }
    
    v.elementAt(0).setUsername("Ali");
    v.elementAt(0).setPass("123@");
    v.elementAt(0).setEmail("ali123@gmail.com");
    v.elementAt(0).setContact("12345678910");
    
    
    for(int i=1;i<4;){
		System.out.print("Enter Username: ");
		user = in.readLine();
		System.out.print("Enter Password: ");
		password = in.readLine();
    
    	//"available[]" is the SEAT AVAILABLE//
		//store 20 seats every destination [1-5]//
    	for(int o=1; o<=5; o++){
    		available[o]=20;
  		}
    for(int index=0;index<=total;index++)
    	//if user and password are correct proceed to MAIN MENU//
    	if(user.equals((v.elementAt(index).getUsername())) && password.equals((v.elementAt(index).getPass()))){
    	
    		for(int x=1; x==1;){
    			//the MAIN MENU//
    			customer.mainMenu();
    	
    			for(x=1; x==1;){
					System.out.print("ENTER CHOICE: ");
					choice=in.readLine();
					
//if CHOICE is "1" display the SCHEDULE//
					if (choice.equals("1")){
						//the DESTINATION DETAILS//
						customer.BusSchedule(available);	
    					x=0;
					}
					
//if CHOICE is "2" proceed to Ticket Booking//
					else if (choice.equals("2")){
						int print=1;
						//display first the Destination Details//
						customer.BusSchedule(available);
    					
    					
    					if((available[1]==0)&&(available[2]==0)&&(available[3]==0)&&(available[4]==0)&&(available[5]==0)){
    						System.out.println("Sorry, We don't  have available seats for all Destination!");
    						x=0;	
    					}
    					//inputing of Passenger's Name//
    					else{
    					for(x=1; x==1;){
    						System.out.print("\n PASSENGER'S NAME: ");
    						ticketS[z][0] = v.elementAt(index).getUsername();
    						System.out.print(ticketS[z][0]);
    						System.out.print("\n");
							x=0;
							
							//if Passenger's Name already used, display error and go back to Inputing//
    						for(int l=0; l<z; l++){
    							if(ticketS[l][0].equalsIgnoreCase(ticketS[z][0])){
    								System.out.println("Sorry, Passenger's name have already used!");
    								x=1;
    							}
    						}
    					}
    					
    					//inputing of Destination//
    					//integers Only [1-5]//
    					for(x=1; x==1;){
    						System.out.print("ENTER DESTINATION [number]: ");
    						destNo = Integer.parseInt(in.readLine());
    						
    						//if Inputed integers are "<1" or ">5", display error and go back to Inputing//
    						if(destNo<1 || destNo>5){
    							System.out.println("Invalid Input! We have total 1-5 destinations.");
    							x=1;
    						}
    						//if available seat is equal to "Zero", display error and go back to Inputing//
    						for(int d=1; d<=5; d++){
    							if(destNo==d){
    								if(available[destNo]==0){
    									System.out.println("Sorry, We don't have available seat!");
    									x=1;
    								}
    								x=0;
    							}
    						}
    					}
    					
    					//convert the integer to string//
    					String dest[] = { " ", "ISLAMABAD", "LAHORE", "KARACHI", "PESHAWAR", "CHINIOT"};
    					double fare[] = { 0,700,350,1000,500,200};
    		
    					//converted integer to string, transfer to storage array//
    					ticketS[z][1] = dest[destNo];
    					ticketD[z][0] = fare[destNo];
    					
    					//inputing for Number of Passenger's//
    					for(x=1; x==1;){
    					System.out.print("HOW MANY PASSENGERS ARE YOU?: ");
    					ticketI[z][0] = Integer.parseInt(in.readLine());
    		
    						//subtract the available seat by the the number inputed//
    						for(int p=1; p<=5; p++){
    							if(destNo==p){
    								print=1;
    								available[destNo] = available[destNo]-ticketI[z][0];
    								
    								//if the subtracted available seat is "<0", display error//
    								//add the inputed number to the subtracted seat, to back the original seat//
    								//display the available seat and back to the inputing//
    								if(available[destNo]<0){
    									System.out.print("Sorry, We don't have seat available for " +ticketI[z][0] +" person\n");
    									available[destNo] = available[destNo]+ticketI[z][0];
    									System.out.print("We only have " +available[destNo] +" seat available\n");
    									x=1;
    									print=0;
    								}
    								else{
    									x=0;
    								}
    							}
    						}
    		
    					}
    					
    					//inputing for Number of Discounted Passenger's//
    					for(x=1;x==1;){
    						System.out.print("HOW MANY PASSENGERS HAVE DISCOUNT?: ");
    						ticketI[z][1] = Integer.parseInt(in.readLine());
    					
    						if(ticketI[z][1]>ticketI[z][0]){
    							
    							System.out.println("Invalid Input!");
    							System.out.println("No. of Passengers are only " +ticketI[z][0] +"!");
    						x=1;
    						}
    						else{
    							break;
    						}
    					}
    		
    		
    					//print out of passengers details....
    					if(print==1){
    						customer.CustomerDetails(ticketS,ticketI,ticketD,z);
    						ticketS[z][2]="0";
    						double discount=(ticketD[z][0]-(ticketD[z][0]*0.2))*ticketI[z][1];
    						ticketD[z][2]= ((ticketI[z][0]-ticketI[z][1])*ticketD[z][0])+discount;
    						x=0;
    					}
    					z++;
    					}
					}
//if choice 3 generate bill
					else if (choice.equals("3")){
			          
			            
						for(x=1; x==1;){
							
								System.out.print("ENTER PASSENGER'S NAME: ");
								search = in.readLine();
								
								
								int s=1;
								for(int b=0;b<z;b++){
									if(search.equalsIgnoreCase(ticketS[b][0])){
										customer.Billing(ticketS,ticketI,ticketD,b,pay,change);
	    								s=0;
										x=0;
										
										if(ticketS[b][2].equals("x")){
	    									System.out.println("Passenger's Already Paid!");
	    									x=0;
	    								}
	    								else{
	    									ticketS[b][2]="x";
	    									
	    								
	    									for(x=1; x==1;){
	    										System.out.println("\nPASSENGER'S TOTAL FARE: Rs "+ticketD[b][2]);
	    										System.out.print("ENTER AMOUNT TO PAY: ");
	    										pay[b] = Double.parseDouble(in.readLine());
	    										change[b]=pay[b]-ticketD[b][2];
	    							
	    										if(change[b]<0){
	    											System.out.println("Invalid Input!");
	    											x=1;
	    										}
	    										else{
	    											System.out.println("CHANGE: Rs "+change[b]);
	    											System.out.println("");
	    											x=0;
	    										}
	    									}
										}
									}
								}
								if (s==1){
									System.out.println("\nPASSENGER'S NAME NOT FOUND!\n");
									for(int q=1; q==1;){
									
									System.out.print("Do you wish to continue with this transaction? [Y/N]: ");
									again=in.readLine();
									
									if(again.equalsIgnoreCase("y")){
										q=0;
									}
									else if (again.equalsIgnoreCase("n")){
										q=0;
										x=0;
										
									}
									else{
										System.out.println("\nInvalid input!\n");
									}
								
						
								}
							}	
						}
			            
					}
//if choice=4 view customer billing details		
					else if (choice.equals("4")){
						
						
						for(int sx=1; sx<=3;){
 						System.out.print("SEARCH PASSENGER'S NAME: ");
    					search = in.readLine();
    		    
    		 		   	int s=1;
							for(x=0; x<=z; x++){
								if(search.equalsIgnoreCase(ticketS[x][0])){
									customer.CustomerDetails(ticketS,ticketI,ticketD,x);
    								s=0;
								    sx=4;
								}
							}	
						
							
							if (s==1){
								System.out.println("Passenger's Name not found!");
								sx++;
							}
							
				    	}
					}		
//if choice=5 print thank you and end program
					else if(choice.equals("5")){
						end=1;
						x=0;
						System.out.println("Thank You!");
					}
				
					else{
						System.out.println("Invalid Input!");
						x=1;
					}
    			}
    	
    			for(y=1; y==1;){
    				if(end==1){
    					break;
    				}
    				System.out.print("Do you want another transaction? [Y/N]: ");
   				 	yn = in.readLine();
    	
    				if (yn.equalsIgnoreCase("y")){
    					x=1;
    					y=0;
    				}
    				else if (yn.equalsIgnoreCase("n")){
    					System.out.println("\nThank You!!!");
    					break;
    				}
    				else{
    					System.out.println("Invalid Input!!!");
    					y=1;
    				}
    			}
    		}
    		i=4;
    	}
    	else {
    		for(int m=0;m<=total;m++) {
    		System.out.print("You have to register first.\n");
    		System.out.print("Enter Username: ");
    		user = in.readLine();
    		v.elementAt(m).setUsername(user);
    		v.elementAt(m).getUsername();
    		System.out.print("Enter Password: ");
    		password = in.readLine();
    		v.elementAt(m).setPass(password);
    		v.elementAt(m).getPass();
    		System.out.print("Enter Email: ");
    		email = in.readLine();
    		v.elementAt(m).setEmail(email);
    		v.elementAt(m).getEmail();
    		System.out.print("Enter Contact Number: ");
    		contact = in.readLine();
    		v.elementAt(m).setContact(contact);
    		v.elementAt(m).getContact();
    		System.out.print("You are successfully registered!! \n");
    		total++;
    		break;
    		
    		}
    	}
    }
	
  }  
}
  
    


