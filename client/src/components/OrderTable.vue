<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">Doctor'S Order Information</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="8">
        <table style="width:100%">

  <tr>
    <td>No</td>
    <td>Date</td>
    <td>name</td>
    <td> examination </td>
    <td>medicine</td>
    <td>medicationType</td>
    <td>Doctor</td>

  </tr> 
  <tr v-for="(item) in items" :key="item.id">        
        <td>{{item[0]}}</td>  
        <td>{{item[1]}}</td>
        <td>{{item[2]}}</td> 
        <td>{{item[3]}}</td>
        <td>{{item[4]}}</td>
        <td>{{item[5]}}</td>
        <td>{{item[6]}}</td>
  </tr>


</table>



      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  name: "ViewRentalData",
  data() {


    return {
     
      items: [],
      data:[],
      allItem:[],
      
    };
  },

  created: function () {

    //this.getVideoRentals();
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล VideoRental ใส่ combobox
    getVideoRentals() {
      http
        .get("/ordertable/"+this.$route.params.id)
        .then(response => {
          //this.data = response.data;         
         // var this.items = response.data;
          this.items = response.data ;
          console.log(this.items);

          

         // console.log(obb);
          //console.log(this.items);
          console.log(this.allItem);
        })
        .catch(e => {
          console.log(e);
        });
    },    
    
    refreshList() {
     // this.getVideoRentals();
     // this.chData();
    }
    /* eslint-disable no-console */
  },
  mounted() {
   // this.chData();
    this.getVideoRentals();
  }
};
</script>
