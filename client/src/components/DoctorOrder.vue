<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">ระบบสั่งจ่ายยา</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="4">
        <v-form v-model="valid" ref="form">
          <!-- <v-row justify="center">
            <v-col cols="10">
              <v-text-field
                outlined
                label="Pateint Citizen ID"
                v-model="videoRental.customerId"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-text-field>
              <p v-if="customerCheck != ''">Pateint Name : {{customerName}}</p>
            </v-col>
            <v-col cols="2">
              <div class="my-2">
                <v-btn @click="findCustomer" depressed large color="primary">Search</v-btn>
              </div>
            </v-col>
          </v-row> -->

          <div>
            <!-- <v-row>
              <v-col cols="10"  class="elevation-12">
                <v-select
                  label="Examination"
                  outlined
                  v-model="videoRental.employeeId"
                  :items="employees"
                  item-text="name"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>
            </v-row> -->
            <v-row>
              <!-- <v-col cols="10">
                <v-combobox
                  label="Medicine"
                  outlined
                  v-model="videoRental.rentalId"
                  :items="rentalTypes"
                  item-text="name"
                  item-value="id"
                  multiple
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-combobox>
              </v-col> -->

              <!-- <v-flex md12>
                    <v-row justify="center" class="elevation-12">
                        <v-col cols="10" sm="10" md="6" >
                            <v-combobox
                                v-model="select"
                                :items="items"
                                label="Medicine"
                                multiple
                                chips
                            ></v-combobox>
                        </v-col>
                    </v-row>
                </v-flex> -->
        
              <!-- <v-col cols="10">
                <v-select
                  label="Medication"
                  outlined
                  v-model="videoRental.videoId"
                  :items="videos"
                  item-text="title"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col> -->

                <v-flex md12>
                    <v-row justify="center" class="elevation-12">
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
                    <v-row justify="center" class="elevation-12">
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
                        <v-col cols="10" sm="10" md="6">
                            <v-select
                                v-model="doctorsOrder.medicationTypeIds"
                                :items="medicationType"
                                item-text="typeName"
                                item-value="id"
                                chips
                                multiple
                                label="MedicationType"
                            ></v-select>
                        </v-col>
                    </v-row>
                </v-flex>


                <!-- <v-row justify="center" class="elevation-12">
                  <v-col cols="12" sm="10" md="6">
                    <v-menu
                      v-model="menu2"
                      :close-on-content-click="false"
                      transition="scale-transition"
                      offset-y
                      
                    >
                      <template v-slot:activator="{ on }">
                        <v-text-field
                          v-model="computedDateFormatted"
                          label="Date"
                          hint="MM/DD/YYYY"
                          persistent-hint
                          prepend-icon=""
                          readonly
                          v-on="on"
                        ></v-text-field>
                      </template>
                      <v-date-picker v-model="date" no-title @input="menu2 = false"></v-date-picker>
                    </v-menu>
                    <p>Date: <strong>{{ date }}</strong></p>
                  </v-col>
              </v-row> -->


            </v-row>
           
            <v-row justify="center">
              <v-col cols="12">
                <v-btn @click="setDoctorsOrder" :class="{ red: !valid, green: valid }">Order</v-btn>
                <v-btn style="margin-left: 15px;" @click="clear">clear</v-btn>
              </v-col>
            </v-row>
            <br />
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
      customerCheck: false,
      customerName: "",
      examinaton:[],
      medicationType:[],
      medicine:[],
      date:"",
      menu2:true,
      computedDateFormatted:"",
      //medicines:[],
      //medicationTypes:[]
    
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
    // function ค้นหาลูกค้าด้วย ID
    // findCustomer() {
    //   http
    //     .get("/customer/" + this.videoRental.customerId)
    //     .then(response => {
    //       console.log(response);
    //       if (response.data != null) {
    //         this.customerName = response.data.name;
    //         this.customerCheck = response.status;
    //       } else {
    //         this.clear()
    //       }          
    //     })
    //     .catch(e => {
    //       console.log(e);
    //     });
    //   this.submitted = true;
    // },
    // function เมื่อกดปุ่ม submit
    setDoctorsOrder() {
      http
        .post(
          "/postDoctor",this.doctorsOrder
            
        )
        .then(response => {
          console.log(response);
          this.$router.push("/viewtable/"+response.data.id);
        })
        .catch(e => {
          console.log(e);
        });
      
      console.log(this.doctorsOrder);
      this.submitted = true;
    },
    clear() {
      this.$refs.form.reset();
      this.customerCheck = false;
    },
    refreshList() {
      this.getMedicine()
      this.getExamination();
      this.getMedicationType();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    // this.getEmployees();
    // this.getVideos();
    // this.getRentalTypes();

    this.getMedicine()
    this.getExamination();
    this.getMedicationType();
  }
};
</script>
