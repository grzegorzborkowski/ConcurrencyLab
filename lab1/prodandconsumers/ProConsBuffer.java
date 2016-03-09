class ProConsBuffer {
        String message;
        Boolean isEmptyBuffer;

        public ProConsBuffer() {
            this.message = "";
            isEmptyBuffer = false;
        }

        public synchronized String take() {
            // if there is a string, a consumer can take it
            // if no, he needs to wait for the Producent to put it
            while(isEmptyBuffer) {
                try {
                    wait();
                } catch(InterruptedException e) {}
            }
            String s = message;
            System.out.println("Consuming : " + s);
            isEmptyBuffer = !isEmptyBuffer;
            notifyAll();
            return s;
        }

        public synchronized void put(String s) {
        // two cases: there is a string and we have to wait for Consumer to take
        // there is no string and we just insert the string
            while(!isEmptyBuffer) {
                try {
                    wait();
                } catch(InterruptedException e) { }
            }
            message = s;
            System.out.println("Producing " + message);
            isEmptyBuffer = !isEmptyBuffer;
            notifyAll();
        }
}