<template>
  <v-container>
    <v-layout text-center wrap>
       <v-flex md12  class="mt-1">
                    <v-img
                    :src="require('../assets/pills.png')"
                    class="my-3"
                    contain
                    height="200"
                    ></v-img>
        </v-flex>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">ระบบสั่งจ่ายยา</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="12">
        <v-form v-model="valid" ref="form">
          <div>
            
                <v-flex md12>
                    <v-row justify="center" >
                        <v-col cols="12" sm="10" md="6">
                            <v-select
                            v-model="doctorsOrder.examinationId"
                            :items="examinaton"
                            item-text="symptom"
                            item-value="id"
                            label="Examination"
                            ></v-select>
                        </v-col>
                    </v-row>
                </v-flex>

                <v-flex md12>
                    <v-row justify="center">
                        <v-col cols="12" sm="10" md="6" >
                            <v-select
                                v-model="doctorsOrder.medicineIds"
                                :items="medicine"
                                item-text="mname"
                                item-value="id"
                                label="Medicine"
                                multiple
                                chips
                            ></v-select>
                        </v-col>
                    </v-row>
                </v-flex>
    
                <v-flex md12>
                    <v-row justify="center">
                        <v-col cols="12" sm="10" md="6">
                            <v-select
                                v-model="doctorsOrder.medicationTypeIds"
                                :items="medicationType"
                                item-text="typeName"
                                item-value="id"
                                chips
                                multiple
                                label="Medication Type"
                            ></v-select>
                        </v-col>
                    </v-row>
                </v-flex>
            
           
            <v-row md12 class="bt1" justify="center">
              <v-col cols="12" class="button1">
                <v-btn @click="checkMedecine" :class="{ red: !valid, green: valid }">Order</v-btn>
                <v-btn style="margin-left: 15px;" @click="clear">clear</v-btn>
              </v-col>
            </v-row>
            <!-- <v-row md12 class="bt2">
              <v-col cols="12" class="button2">
                <v-btn @click="viewtable" :class="red">View Doctor's Order</v-btn>
                
              </v-col>
            </v-row> -->
            
            <!-- class="elevation-12" -->
            
          </div>
        </v-form>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  name: "doctorsOrder",
  data() {
    return {
      doctorsOrder: {
        examinationId: "",
        medicineIds: [],
        medicationTypeIds: []
        
      },
      valid: false,
      examinaton:[],
      medicationType:[],
      medicine:[],
      date:"",
      menu2:true,
      
    
    };
  },
  methods: {
    /* eslint-disable no-console */

    getExamination() {
      http
        .get("/examinationSystem")
        .then(response => {
          this.examinaton = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    getMedicine() {
      http
        .get("/medicine")
        .then(response => {
          this.medicine = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล MedicationType ใส่ combobox
    getMedicationType() {
      http
        .get("/medicationType")
        .then(response => {
          this.medicationType = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    checkMedecine(){
      if((this.doctorsOrder.medicationTypeIds.length > this.doctorsOrder.medicineIds.length) || (this.doctorsOrder.medicationTypeIds.length < this.doctorsOrder.medicineIds.length)){
        console.log("เข้าฟังก์ชั่น")
        alert("เลือกจำนวน Medication Type ให้สอดคล้องกับจำนวน Medicine");
        
      }
      else {
        this.setDoctorsOrder();
      }
    },
  
    setDoctorsOrder() {
      console.log("this.doctorsOrder = " + this.doctorsOrder);
      http
        .post( "/postDoctor",this.doctorsOrder)
        .then(response => {        
            this.clear;
            alert("Created Order Successfully");
            // this.$router.push("/viewtable/"+response.data.id);
            this.$router.push("/viewtable/"+response.data.id);
          
        })
        .catch(e => {
          console.log(e);
          alert("Can Not Create Order ! \nสั่งจ่ายยาแล้ว");
          this.clear();

        });
      
      console.log(this.doctorsOrder);
      this.submitted = true;
    },
    
    clear() {
      this.$refs.form.reset();
    },


    refreshList() {
      this.getMedicine()
      this.getExamination();
      this.getMedicationType();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.getMedicine()
    this.getExamination();
    this.getMedicationType();

  }
};
</script>

<style scoped>
.bt1 {
    text-align: center;
}

.button1 {
    position: absolute;
    top: 85%;
    text-align: center;
}
</style>
