public class MyRunner{
	public static void main(String[]args){
		System.out.println("Integer Lists");
		SuperList<Integer> list = new SuperList<Integer>();
		for(int i = 0; i < 30; i++){
			list.add((int)(Math.random() * 1000) + 1);
		}
		System.out.println("Original List: "+list);
		System.out.println("Size: "+list.size());

		System.out.println("\nSuperList to Stack");
		SuperList<Integer> stack = new SuperList<Integer>();
		while(list.size() != 0){
			stack.push(list.remove(0));
		}
		System.out.println("Stack: "+stack);
		System.out.println("Size: "+stack.size());

		System.out.println("\nStack to Queue");
		SuperList<Integer> queue = new SuperList<Integer>();
		while(stack.size()!=0){
			queue.add(stack.pop());
		}
		System.out.println("Queue: "+queue);
		System.out.println("Size: "+queue.size());

		System.out.println("\nStack to Queue");
		while(queue.size()!=0){
			int rand = (int)(Math.random()*list.size());
			int val = queue.peekQueue();
			list.add(rand, queue.poll());
		}
		System.out.println("Random List: "+list);
		System.out.println("Size: "+list.size());

		System.out.println("\nSums");
		int sum = 0;
		int evenSum = 0;
		int oddSum = 0;
		for(int i = 0; i < list.size(); i++){
			sum+=list.get(i);
			if(i%2 == 0)
				evenSum+=list.get(i);
			else
				oddSum+=list.get(i);
		}
		System.out.println("Sum: "+sum);
		System.out.println("Even Sum: "+evenSum);
		System.out.println("Odd Sum: "+oddSum);

		System.out.println("\nMake Duplicates");
		int tempSize = list.size();
		for(int i = 0; i < tempSize; i++){
			int value = list.get(i);
			if(value%2 == 0)
				list.add(value);
		}
		System.out.println("Duplicates List: "+list);
		System.out.println("Size: "+list.size());

		System.out.println("\nRemove all %3");
		for(int i = 0; i < list.size(); i++){
			int value = list.get(i);
			if(value%3 == 0)
				list.remove(i);
		}
		System.out.println("New List: "+list);
		System.out.println("Size: "+list.size());

		System.out.println("\nSort in ascending order");
		for (int i = 0; i < list.size() - 1; i++) {
			int pos = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) < list.get(pos))
					pos = j;
				int min = list.get(pos);
				list.add(pos, list.get(i));
				list.remove(pos+1);
				list.add(i, min);
				list.remove(i+1);
			}
		}
		System.out.println("Sorted List: "+list);
		System.out.println("Size: "+list.size());

		System.out.println("\nMedian");
		int medIndex = 0;
		int medIndex1 = 0;
		int medIndex2 = 0;
		int medValue = 0;
		if(list.size()%2 != 0){
			medIndex = (list.size()-1)/2;
			medValue = list.get(medIndex);
			System.out.print("Fir Half: [");
			for(int i = 0; i < medIndex; i++){
				System.out.print(list.get(i));
				if(i != medIndex-1)
					System.out.print(", ");
			}
			System.out.print("]");
			System.out.println("\nMedian: "+medValue);
			System.out.print("Sec Half: [");
			for(int i = medIndex+1; i < list.size(); i++){
				System.out.print(list.get(i));
				if(i != list.size()-1)
					System.out.print(", ");
			}
			System.out.println("]");
		}
		else{
			medIndex2 = (list.size())/2;
			medIndex1 = medIndex2-1;
			medValue = (list.get(medIndex1)+list.get(medIndex2))/2;
			System.out.print("Fir Half: [");
			for(int i = 0; i < medIndex1+1; i++){
				System.out.print(list.get(i));
				if(i != medIndex1)
					System.out.print(", ");
			}
			System.out.print("]");
			System.out.println("\nMedian: "+medValue);
			System.out.print("Sec Half: [");
			for(int i = medIndex2; i < list.size(); i++){
				System.out.print(list.get(i));
				if(i != list.size()-1)
					System.out.print(", ");
			}
			System.out.println("]");
		}
		System.out.println("\nString Lists");
		String str = "In non-functional linguistics, a sentence is a textual unit consisting of one or more words that are grammatically linked.";
		SuperList<String> words = new SuperList<String>();
		String[] temp = str.split(" ");
		for(int i = 0; i < temp.length; i++){
			String clean = "";
			for(int j = 0; j < temp[i].length(); j++){
				char c = temp[i].charAt(j);
				if((c >= 65 && c <= 90)||(c >= 97 && c <= 122)){
					clean = clean+c;
				}
			}
			words.add(clean);
		}
		System.out.println("Scentece List: "+words);
		System.out.println("Size: "+words.size());

		System.out.println("\nTake out <= 3");
		for(int i = 0; i < words.size(); i++){
			if(words.get(i).length() <= 3){
				words.remove(i);
				i--;
			}
		}
		System.out.println("Scentece List: "+words);
		System.out.println("Size: "+words.size());

		for (int i = 1; i < words.size(); i++) {
			String curr = words.get(i);
			int j = i-1;
			while ((j > -1) && (words.get(j).compareTo(curr) > 0)){
				words.add(j+1, words.get(j));
				words.remove(j+2);
				j--;
			}
			words.add(j+1, curr);
			words.remove(j+2);
        }
		System.out.println("Sorted Scentece: "+words);
		System.out.println("Size: "+words.size());

		System.out.println("\nAverage");
		int len = 0;
		for(int i = 0; i < words.size(); i++){
			len+=words.get(i).length();
		}
		System.out.println("Avg Word Length: "+(double)len/words.size());
	}
}