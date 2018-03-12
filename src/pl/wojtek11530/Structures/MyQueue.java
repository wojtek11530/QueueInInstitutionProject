package pl.wojtek11530.Structures;

import pl.wojtek11530.Exceptions.EmptyQueueException;

public class MyQueue<E> {
	private class Element{
		 private E value;
		 private Element next;
		 
		 public E getValue() {
			 return value;
		 }
		 
		 public void setValue(E value) {
			 this.value = value;
		 }
		 
		 public Element getNext() {
			 return next;
		 }
		 
		 public void setNext(Element next) {
			 this.next = next;
		 }
		 
		 Element(E data){
			 this.value=data;
		 }
	 }
	
	 private Element head;
	 public MyQueue(){}

	public Element getHead() {
		return head;
	}

	public void setHead(Element head) {
		this.head = head;
	}

	public boolean isEmpty(){
		 return head==null;
	 }
	 
	 
	 public void clear() {
		 head=null;
	 }

	 public int size() {
		 int index = 0;
		 Element currentElement = head;
		 
		 if (currentElement==null) {
			 return index;
		 }else {
			 while (currentElement!=null) {
				 index++;
				 currentElement = currentElement.getNext();
			 }
			 return index;
		 }
	 }
	 
	 public E peek() throws EmptyQueueException {
	 	if (isEmpty()) {
			throw new EmptyQueueException();
		}else {
			return head.getValue();
		}
	 }
	 
	 public E dequeue() throws EmptyQueueException{
		 if (isEmpty()) {
			 throw new EmptyQueueException();
		 }else {
			 E returnedValue = head.getValue();
			 head = head.getNext();
			 return returnedValue;
		 }
	 }
	 
	 public void enqueue(E object) {
		 if (head==null) {
			 head = new Element(object);
		 }else {
			 Element currentElement = head;
			 while (currentElement.getNext()!=null) {
				 currentElement = currentElement.getNext();
			 }
			 currentElement.setNext(new Element(object));
		 }
	 }
	 
	 public boolean contains(E object) {
		 if (head==null) {
			 return false;
		 }else {
			 Element currentElement = head;
			 while (currentElement!=null) {
				 if (currentElement.getValue().equals(object)) {
					 return true;
				 }
				 currentElement = currentElement.getNext();
			 }
			 return false;
		 }
	 }
	 
	 public int indexOf(E object) {
		 if (head==null) {
			 return -1;
		 }else {
			 Element currentElement = head;
			 int i = 0;
			 while (currentElement!=null) {
				 if (currentElement.getValue().equals(object)) {
					 return i;
				 }
				 currentElement = currentElement.getNext();
				 i++;
			 }
			 return -1;
		 }
	 }

	 public void printQueue(){
		Element currentElement = head;
		int index = 1;
		System.out.println("Queue:");
		while (currentElement!=null) {
			System.out.println(index + "." + currentElement.getValue());

			index++;
			currentElement = currentElement.getNext();
		}
		 System.out.println();
	 }
	 
	 
}
