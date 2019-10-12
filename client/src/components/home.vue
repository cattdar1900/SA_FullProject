<template>
  <v-container>
    <v-row justify="center" >
    <v-col cols="20" >
      <h1>username : {{user.id}}</h1>
      <h1>เข้าสู่ระบบในฐานะ : {{user.job}}</h1>
      </v-col>
      </v-row>
     
            

  </v-container>
</template>



<script>
import http from "../http-common";

export default {
  name: "home",
  data() {
    return {
      Patient: {
        


      },
      valid: false,
      customerCheck: false,
      customerName: "",
      user:{}
      //+this.$route.params.id
    };
  },
  methods: {
    /* eslint-disable no-console */
     getUser() {
      http
        .get("/User/"+this.$route.params.id)
        .then(response => {
          this.user = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
  

 
   
  },
  mounted() {
    this.getUser();
    
  }
};
</script>
