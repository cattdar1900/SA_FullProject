<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">ระบบลงทะเบียนผู้ปป่วยใน</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="10">
        <v-form v-model="valid" ref="form">
          <v-row justify="center">
            <v-col cols="10">
              <v-text-field
                outlined
                label="ชื่อ - นามสกุล"
                v-model="Patient.name"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-text-field>

              <v-text-field
                outlined
                label="รหัสบัตรประจำตัวประชาชน"
                v-model="Patient.nationalID"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-text-field>

              <v-row justify="center">
                <v-col cols="6">
                  <v-text-field
                    outlined
                    label="น้ำหนัก"
                    v-model="Patient.weigth"
                    :rules="[(v) => !!v || 'Item is required']"
                    required
                  ></v-text-field>
                </v-col>

                <v-col cols="6">
                  <v-text-field
                    outlined
                    label="ส่วนสูง"
                    v-model="Patient.hight"
                    :rules="[(v) => !!v || 'Item is required']"
                    required
                  ></v-text-field>
                </v-col>
              </v-row>

              <v-textarea
                outlined
                label="ที่อยู่"
                v-model="Patient.address"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-textarea>

              <v-textarea
                outlined
                label="อาการเบื้องต้น"
                v-model="Patient.initialSsym"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-textarea>

               <v-row justify="center">
                <v-col cols="3">
                  <v-select
                    label="เพศ"
                    outlined
                    v-model="Patient.gender"
                    :items="genders"
                    item-text="name"
                    item-value="id"
                    :rules="[(v) => !!v || 'Item is required']"
                    required
                  ></v-select>
                </v-col>

                <v-col cols="4">
                  <v-select
                    label="จังหวัด"
                    outlined
                    v-model="Patient.province"
                    :items="provinces"
                    item-text="name"
                    item-value="id"
                    :rules="[(v) => !!v || 'Item is required']"
                    required
                  ></v-select>
                </v-col>

                <v-col cols="5">
                  <v-select
                    label="สิทธิการรักษา"
                    outlined
                    v-model="Patient.benefit"
                    :items="benefits"
                    item-text="name"
                    item-value="id"
                    :rules="[(v) => !!v || 'Item is required']"
                    required
                  ></v-select>
                </v-col>
              </v-row> 

              <v-row justify="center">
                <v-col cols="20">
                  <v-btn @click="saveVideoRental" :class="{ red: !valid, green: valid }">submit</v-btn>
                  <v-btn style="margin-left: 15px;" @click="clear">clear</v-btn>
                </v-col>
              </v-row>
            </v-col>
          </v-row>

          
        </v-form>
      </v-col>
    </v-row>

    <!-- <div>
    <h3>ระบบลงทะเบียนผู้ป่วยใน</h3>
    <div class = "form-group">
      
    <div class="md-layout md-gutter"> 
      <md-field>
      <label>ชื่อ - นามสกุล</label>
      <md-input ></md-input>
    </md-field>

   <md-field>
      <label>รหัสบัตรประจำตัวประชาชน</label>
      <md-input ></md-input>
    </md-field>
    

        <md-field>
        <label for="type">เพศ</label>
          <md-select v-model="type" name = "type">
            <md-option value = "man">ชาย</md-option>
            <md-option value = "women">หญิง</md-option>
          </md-select>
          </md-field>

      <md-field>
            <label >วันเดือนปีเกิด</label>
           <md-datepicker v-model="selectedDate" />
           </md-field>

    <md-field>
        <label for="rule">สิทธิการรักษา</label>
          <md-select v-model="rule" name = "rule">
            <md-option value = "1">สิทธิผู้สูงอายุ</md-option>
            <md-option value = "2">สิทธิบิัตรทอง 30 บาท</md-option>
            <md-option value = "3">สิทธิประกันสังคม</md-option>
            <md-option value = "4">สิทธิครอบครังข้าราชการ</md-option>
            <md-option value = "5">สิทธิผู้พิการ</md-option>
            <md-option value = "6">สิทธินักศึกษา</md-option>
          </md-select>
          </md-field>

        <md-field>
        <label for="rule">จังหวัด</label>
          <md-select v-model="rule" name = "rule">
            <md-option value = "1">ชัยภูมิ</md-option>
            <md-option value = "2">นคราชสีมา</md-option>
            <md-option value = "3">ขอนแก่น</md-option>
            <md-option value = "4">มหาสารคาม</md-option>
            <md-option value = "5">กรุงเทพมหานคร</md-option>
            <md-option value = "6">เชียงใหม่</md-option>
          </md-select>
          </md-field>

<md-field>
      <label>ที่อยู่</label>
      <md-textarea v-model="textarea"></md-textarea>
    </md-field>

    <md-field>
      <label>อาการเบื้องต้น</label>
      <md-textarea v-model="textarea" ></md-textarea>
    </md-field>

          

    </div>
         
      
    

      <div>
      <md-button class="md-dense md-raised md-primary">ยืนยัน</md-button>
      <md-button class="md-dense md-primary">ยกเลิก</md-button>
      
    </div>  
    </div>
			

			

    
    </div>-->
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  name: "Patient",
  data() {
    return {
      Patient: {
        name : "",
        nationalID : "",
        weigth : "",
        hight : "",
        address : "",
        initialSsym : "",
        gender : "",
        province : "",
        benefit : ""


      },
      valid: false,
      customerCheck: false,
      customerName: "",
      benefits:[],
      genders:[],
      provinces:[]
    };
  },
  methods: {
    /* eslint-disable no-console */

    // ดึงข้อมูล Employee ใส่ combobox
    getGender() {
      http
        .get("/gender")
        .then(response => {
          this.genders = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Video ใส่ combobox
    getProvince() {
      http
        .get("/province")
        .then(response => {
          this.provinces = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล RentalType ใส่ combobox
    getBenefit() {
      http
        .get("/benefit")
        .then(response => {
          this.benefits = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
  
    
    // function เมื่อกดปุ่ม submit
    saveVideoRental() {
      http
        .post(
          "/patientPost",
          this.Patient     
        )
        .then(response => {
          console.log(response);
        })
        .catch(e => {
          console.log(e);
        });

        console.log(this.Patient);

        http
        .get("/patient")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },
    clear() {
      this.$refs.form.reset();
      this.customerCheck = false;
    },
    refreshList() {
      this.getGender();
      this.getProvince();
      this.getBenefit();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.getGender();
    this.getProvince();
    this.getBenefit();
  }
};
</script>
