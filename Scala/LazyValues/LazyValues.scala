  object Main {

	def compute(x: Int): Int = {
		println("...Computing...")
		x*x
	}
		
    def main(args: Array[String]) {
    	val x = 2

    	//The lazy value allows the compute computation to be deferred
		lazy val temp = compute(x)

		//Here the compute will only get invoked if it is read
		if(x >= 2 && temp <= 7) {

			//Here, the temp value called previously is cached due to it being lazy
			//so compute is not called again
			println("Condidtion passes, computed value is: ", temp)
		} else {
			println("Condition failed")
		}
    }
  }