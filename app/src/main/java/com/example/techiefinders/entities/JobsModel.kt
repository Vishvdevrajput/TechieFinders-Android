package com.example.techiefinders.entities

class JobsResponse(var jobs: ArrayList<JobsModel>)
class JobsModel(var jobId: String, var jobName: String, var jobDes: String, var npApplied: Int, var npReq: Int, var jpId: String, var skill: ArrayList<TagData>, var appliedList : ArrayList<AppliedData>,  var suggestedList: ArrayList<AppliedData>)
class TagData(var tag: String)
class AppliedData(var apId: String, var name: String, var imageUrl : String,var skill: ArrayList<TagData>, var applied: Boolean)