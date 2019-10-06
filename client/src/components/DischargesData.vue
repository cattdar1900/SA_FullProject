<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">Discharge Information</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="8">
        <v-data-table :headers="headers" :items="items" :items-per-page="5" class="elevation-1">
        </v-data-table>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  name: "DischargesData",
  data() {
    return {
      headers: [
        {
          text: "Patient",
          align: "left",
          sortable: false,
          value: "patient.name"
        },
        { text: "sensorium", value: "sensorium.name" },
        { text: "Selfcare", value: "selfcare.name" },
        { text: "DistributionType", value: "type.name" },
        { text: "LeaveDate", value: "leave" },
        { text: "Note", value: "note" }

      ],
      items: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล VideoRental ใส่ combobox
    getDischarge() {
      http
        .get("/discharge")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getDischarge();
    }
    /* eslint-disable no-console */
  },
  mounted() {
    this.getDischarge();
  }
};
</script>
