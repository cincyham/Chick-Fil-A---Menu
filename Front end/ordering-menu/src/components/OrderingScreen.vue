<template>
  <div id="ordering-screen">
      <div id="checkout-list" class="ordering-screen-element">

      </div>
      <div id="buttons" class="ordering-screen-element">
        <h2 id="tender-button">
          Tender
        </h2>
      </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
 #ordering-screen {
  background-color: #0096FF;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
 }
 div#buttons {
  text-align: center;
 }
 #tender-button {
  color: red;
  display: inline-block;
  background-color: black;
  height: 50px;
  width: 100px;
 }
</style>