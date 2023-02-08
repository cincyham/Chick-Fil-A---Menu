<template>
  <div id="item-list">
      <div class="item-loop" v-for="item in itemList" :key="item.id">
        <img id="item-picture" :src="item.picture" alt="Item Picture">
      </div>
  </div>
</template>

<script>
import itemService from "../services/itemService";

export default {

  created() {
    this.retrieveItems();
  },
  methods: {
    retrieveItems() {
      itemService.listItems().then((response) => {
        this.$store.commit("SET_ITEMS", response.data);
      });
    }
  },
  computed: {
    itemList() {
      const itemList = this.$store.state.items;
      return itemList;
    }
  }
}
</script>

<style>
#item-list {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}
.item-loop {
  width: 100px;
}
#item-picture {
  width:  90px;
}
</style>