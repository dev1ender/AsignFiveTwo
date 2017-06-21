//import scanner class from util package for getting input form user
import java.util.ArrayList;
import java.util.Scanner;

//interface stack 
interface Stack{
	
	void push(int l);
	int pop();
}



//varaiblestack class implements stack interface this class is used to create fixed size stack/array
class VariableStack implements Stack{
    private ArrayList<Integer> stackArray;  //stack name 
	int size;			//size of stack
	int top;			//top pointer of stack 
	
	//parameterized constructor which takes size as parameter and assign size to size of stack and initialise the top with -1;
	public VariableStack(int Size){
		this.size=Size;		//assign size to the size parameter 
		stackArray = new ArrayList<Integer>(Size);      //define the size of stack
		
		
		top = -1;
	}
	

	//method is used to take out element from the stack and return it 
	public int pop() {
		if(top < 0){
			System.out.println("Stack is empty");
			return 0;
		}
		else{
			int topvalue = stackArray.get(top--);
			return topvalue;
			
		}
		
	}
	
	//method is used to list all the item of a stack in top to bottom view
	public void Allitems(){
		 System.out.println("All the element in the fixed size stack are");
		 for(int i=top;i>= 0;i--)
			 System.out.println("element at "+(i)+" th index is :" + stackArray.get(i)); // used to print all the items os the stack 
		 System.out.println("top of the :"+stackArray.get(top)); //used to print the top value of the stack 
	 }


	@Override
	public void push(int l) {
		if(size > top+1){
			
		stackArray.add(top+1, l);
		top++;
		}
		else{
			size= size*2;
			stackArray.ensureCapacity(size);   //used to increase the size of the stack if fall short
			stackArray.add(top+1, l);
			top++;
		}
	}
	
	
}

//fixed size class is used to create fxedsixe stack 
class FixedStack implements Stack {
	int stackArray[];   //define stack array
	int size;			//define stack size
	int top;			//varible used to point the top of the stack
	
	//parameterzied constructor used to set the size of stack and intialise the top pointer to -1
	public  FixedStack(int size){
		this.size=size;
		stackArray = new int[this.size]; //set the size of stack
		top = -1;
	}
	
	
	//method used to input the value to stack and raise the pointer to plus one
	public void push(int l) {
		if (CheckOverflow())
			stackArray[++top]=l;
		else
			System.out.println("Stack OverFlow");
			
		
	}

	//check's the feasiablity of element to be inserted check is the stack is already full or nnot
	private boolean CheckOverflow() {
		if(top+1 == size)
		return false;
		else
			return true;
	}

	//method used to take out value from the stack 
	public int pop() {
		int topvalue;
		if(top > -1){
			 topvalue = stackArray[top--];
			return topvalue;
		}
		else{
			topvalue =0;
			System.out.println("Stack is empty");
			return topvalue;
		}
	}
	
	//method is used to list all the item od the stack in top to bottom approach 
	public void Allitems(){
		 System.out.println("All the element in the fixed size stack are");
		 for(int i=top;i>= 0;i--){
			 System.out.println("element at "+(i)+" th index is :" + stackArray[i]); // used to print all the items os the stack
		 }
		 System.out.println("top of the stack :"+pop());  // used to print the top item of the stack
	 }
	
}


//class that contain main method
public class AsignFiveTwo {

	//main method entry point of control
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // used to create scaanner class object that take intput form the user
		
	System.out.println("Enter the Size of Fixed Size Stack");
		int fsSize= sc.nextInt();
		FixedStack fs= new FixedStack(fsSize); //create fized size stack object
		boolean flag=true;
		while(flag){
			        System.out.println("");
					System.out.println("Choose a option");
					System.out.println("Enter 1: Push");
					System.out.println("Enter 2: Pop");
					System.out.println("Enter 3: Show All items of the stack");
					System.out.println("Enter 4: Exit");
					int use = sc.nextInt();
					
					switch(use){
					case 1:
						
						System.out.println("enter a element to be pushed in stack.");
						int l =sc.nextInt();
						fs.push(l);
						break;
						
					case 2:
						int ele =  fs.pop();
						System.out.println(ele+" has been poped out from the stack. ");
						break;
					
					case 3:
						fs.Allitems();
						
						break;
					case 4 : flag=false;break;
					
				    default : System.out.println("Please enter a vaild option.");
						
					}
					
					
					
			
			
		}
		
		System.out.println("Enter the Size of variable Size Stack.");
		int vsSize= sc.nextInt();
		VariableStack vs= new VariableStack(vsSize);  //used to create variable sixe stack object
		boolean vsflag=true;							//flag is used to recursively call the while loop accroding to user requirement
		while(vsflag){
			System.out.println("Choose a option");
			System.out.println("Enter 1: Push");
			System.out.println("Enter 2: Pop");
			System.out.println("Enter 3: Show al items of the stack");
			System.out.println("Enter 4: Exit");
			int use = sc.nextInt();
			
			
			
			//switch case statements having diff case accoring to the user input and perform task as selected by user
			switch(use){
			case 1:
				System.out.println("enter a element to be pushed in stack");
				int l =sc.nextInt();
				vs.push(l);
				break;
				
			case 2:
				int ele =  vs.pop();
				System.out.println(ele+"has been poped out from the stack");
				break;
				
			case 3:
				vs.Allitems();
				break;
			case 4:
				vsflag=false;break;
		
			default : System.out.println("Please enter a vaild option");
				
			}

		
		
	}

		sc.close(); //used to close the resource of scanner class as now unwawnted interface occur 
}
	}
