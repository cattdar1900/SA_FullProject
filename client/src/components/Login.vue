<template>
  <v-container>

      <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">เข้าสู่ระบบ</h1>
      </v-flex>
    </v-layout>
                <v-form v-model="valid" ref="form">
                <v-row justify="center">
                <v-col cols="6">                
                  <v-text-field
                    outlined
                    label="Username"
                    v-model="User.username"
                    :rules="[(v) => !!v || 'Item is required']"
                    required
                  ></v-text-field>
                </v-col>
                 </v-row>

                <v-row justify="center">
                <v-col cols="6">
                  <v-text-field
                    outlined
                    label="Password"
                    type = password
                    v-model="User.password"
                    :rules="[(v) => !!v || 'Item is required']"
                    required
                  ></v-text-field>
                    </v-col>
                 </v-row>
                 </v-form>

                 <v-row justify="center">
                    <v-btn @click="Login" :class="{ red: !valid, green: valid }">Login</v-btn>
                </v-row>
            

  </v-container>
</template>

<script>
import http from "../http-common";

export default {


  name: "Login",
  data() {
    return {
      User: {
          username : "",
          password : ""       
      },
      valid: false,
      customerCheck: false
    };
  },
  methods: {
    /* eslint-disable no-console */
    Login() {
      http
        .post(
          "/User/login",
          this.User     
        )
        .then(response => {
          console.log(response);
          if(this.User.username == response.data){
              alert("User " + response.data +" Login Success !  ");
              this.$router.push("/patient");
          }
          else{
              alert(response.data );           
          }
        })
        .catch(e => {
          console.log(e);
        });
        console.log(this.User);


    },
 
    
    /* eslint-enable no-console */
  },
  mounted() {
   
  }
};
</script>
