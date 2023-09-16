class NumArray {

        int[] arrayNums;
        int[] sumDP;

        public NumArray(int[] nums) {
            this.arrayNums = new int[nums.length];
            this.sumDP = new int[nums.length];

            this.sumDP[0] = nums[0];

            for(int i = 0; i < nums.length; i++){
                this.arrayNums[i] = nums[i];

                if(i > 0){
                    this.sumDP[i] = this.sumDP[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int left, int right) {
            if(left > 0){
                return (this.sumDP[right] - this.sumDP[left - 1]);
            }
            return this.sumDP[right];
        }

    }