package tutorials.utils;


// a wrapper class simulates references 
public class _<E> {
    E ref;
    public _(){
    	ref = null; 
    }
    
    public _( E e ){
        ref = e;
    }
    public E value() { return ref; }
    public void set( E e ){ this.ref = e; }
}