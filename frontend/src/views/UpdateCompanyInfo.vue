<template>
<!-- html -->
      <div>
        <br>
        <div class="form">
          <h1 class="h1">Update company</h1>
          <el-form :model="informationForm" :rules="rules" ref="informationForm">
            <el-form-item label="Company Name" prop="companyName">
                <el-input v-model="informationForm.companyName"></el-input>
            </el-form-item>
            <el-form-item label="Start Up Date" prop="startUpDate" >
                <el-date-picker
                    style="width: 100%;"
                    v-model="informationForm.startUpDate"
                    type="date"
                    placeholder="select a date">
                </el-date-picker>
            </el-form-item>

            <el-form-item label="Owner" prop="owner" >
                <el-input v-model="informationForm.owner"></el-input>
            </el-form-item>

            <el-form-item label="Industry" prop="industry" >
                <el-input v-model="informationForm.industry"></el-input>
            </el-form-item>
            
            <el-form-item>
              <el-button class="submit" type="primary" @click="submitForm('informationForm')">submit</el-button>
              <el-button @click="resetForm('informationForm')">replace</el-button>
            </el-form-item>
          </el-form>
        </div>
        <br>
  </div>
</template>


<script>
export default {
  data() {
        return {
          //rules
            rules: {
                companyName: [
                    { required: true, message: 'Please enter company name!', trigger: 'blur' },
                ],
                startUpDate: [
                    { required: true, message: 'Please enter start up date!', trigger: 'blur' },
                ],
                owner: [
                    { required: true, message: 'Please enter the owner!', trigger: 'blur' },
                ],
                industry: [
                    { required: true, message: 'Please enter industry type!', trigger: 'blur' },
                ],
            },
            
            pickerOptions: {
                disabledDate(time) {
                    return time.getTime() > Date.now();
                }
            },
        };
      
    },
    props:{
        informationForm:{
          type:Object,
          default:""
        }
    },
    methods: {
      submitForm(formName) {
        //update the company
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$axios.put('/api/company/update',this.informationForm).then(res => {
                
            });
          }else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      next() {
        if (this.active++ > 2) this.active = 0;
      },
    }
}




</script>

<style scoped>
.submit{
  background-color: #54c685;
}
.submit:hover{
  background-color: #3ea56a;
}
.submit:focus{
  background-color: #54c685;
}

.form{
  width: 30%;
  margin-left:30.5%;
  margin-top: 5%;
  margin-bottom:5%;
  box-shadow: 5px 10px 5px #888888;
  background-color: rgb(255, 255, 255);
  border-radius: 15px;
  padding:5%;
  padding-top: 3%;
  padding-bottom: 3%;
}
/*css only for small size screen like mobile phone*/
@media only screen and (max-width: 800px) {
  .form{
    width: 80%;
    margin-bottom:5%;
    margin-top: 10%;
    margin-left:6%;
  }
}
</style>