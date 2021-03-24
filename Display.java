/**
 * 
 */
package busReservationSystem;

/**
 * @param <string>
 * 
 *
 */
public class Display {
	void mainMenu() {
		//the MAIN MENU//
		System.out.println("---------------------------------------");
		System.out.println("** BUS RESERVATION SYSTEM            **");
		System.out.println("---------------------------------------");
		System.out.println("** [1] Bus Schedule                  **");
		System.out.println("** [2] Customer Booking              **");
		System.out.println("** [3] Billing                       **");
		System.out.println("** [4] View Customer Details         **");
		System.out.println("** [5] Exit                          **");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------\n");
	};
	void BusSchedule(int available[]) {
		//display the "BUS SCHEDULE ", every destination "Fare", and the "Seat" available//
		System.out.println("---------------------------------------");
		System.out.println("**   SCHEDULE      |  FARE  |  SEAT  **");
		System.out.println("---------------------------------------");
		System.out.println("** 1.)ISLAMABAD    | Rs700  |   "+available[1]+"   **");
		System.out.println("** 2.)LAHORE       | Rs350  |   "+available[2]+"   **");
		System.out.println("** 3.)kARACHI      | Rs1000 |   "+available[3]+"   **");
		System.out.println("** 4.)PESHAWAR     | Rs500  |   "+available[4]+"   **");
		System.out.println("** 5.)CHINIOT      | Rs200  |   "+available[5]+"   **");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------\n");
		System.out.println(" STUDENT & SENIOR CITIZEN with 20% DISCOUNT!!!\n");
	};
	void CustomerDetails(String[][] ticketS,int[][] ticketI, double[][] ticketD,int temp) {
		System.out.println("\n-----------------------------------");
		System.out.println("--        Tickets Confirmed        --");
		System.out.println("-------------------------------------");
		System.out.println("CUSTOMER'S NAME: " + ticketS[temp][0]);
		System.out.println("CUSTOMER'S DESTINATION : " + ticketS[temp][1]);
		System.out.println("FARE PRICE: Rs " + ticketD[temp][0]);
		System.out.println("NO. OF PASSENGERS: " + ticketI[temp][0]);
		System.out.println("NO. OF PASSENGERS WITH DISCOUNT: " + ticketI[temp][1]);
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------\n");
	};
	void Billing(String[][] ticketS,int[][] ticketI, double[][] ticketD,int x,double pay[],double change[])
	{
		System.out.println("-----------------------------------");
		System.out.println("--        Billing DETAILS        --");
		System.out.println("-----------------------------------");
		System.out.println("CUSTOMER'S NAME: " + ticketS[x][0]);
		System.out.println("CUSTOMERS'S DESTINATION : " + ticketS[x][1]);
		System.out.println("FARE PRICE: Rs" + ticketD[x][0]);
		System.out.println("NO. OF PASSENGERS: " + ticketI[x][0]);
		System.out.println("NO. OF PASSENGERS WITH DISCOUNT: " + ticketI[x][1]);
		System.out.println("TOTAL FARE PRICE: Rs " + ticketD[x][2]);
		if(ticketS[x][2].equals("x")){
			System.out.println("PAY: Rs " +pay[x]);
			System.out.println("CHANGE: Rs " +change[x]);
			System.out.println("STATUS: PAID");
		}
		else{
			System.out.println("STATUS: NOT PAID");
		}
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
	};

}

