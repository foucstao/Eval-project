package com.eval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.common.APIReturnData;
import com.base.controller.BaseAPIController;
import com.eval.pojo.ObjNodeTypeEvaluation;
import com.eval.service.ObjNodeTypeEvaluationService;

@RestController
@RequestMapping("api/eval/typeEval")
public class ObjNodeTypeEvaluationController extends BaseAPIController {

	@Autowired
	ObjNodeTypeEvaluationService indexService;

	@GetMapping("/type/{code}")
	public APIReturnData getItem(@PathVariable String code) {
		List<ObjNodeTypeEvaluation> index = indexService.selectByCode(code);
		APIReturnData apiReturnData = new APIReturnData();
		apiReturnData.success();
		apiReturnData.putData("total", index.size());
		apiReturnData.putData("tableList", index);
		return apiReturnData;
	}

	@GetMapping("/obj/{obj}")
	public APIReturnData getNodesByObj(@PathVariable String obj) {
		List<ObjNodeTypeEvaluation> indexes = indexService.selectByObj(obj);
		APIReturnData apiReturnData = new APIReturnData();
		apiReturnData.success();
		apiReturnData.putData("total", indexes.size());
		apiReturnData.putData("tableList", indexes);
		return apiReturnData;
	}

	@GetMapping("/instance/{evalInstance}")
	public APIReturnData getNodesByInstance(@PathVariable String evalInstance) {
		List<ObjNodeTypeEvaluation> indexes = indexService.selectByEvalInstance(evalInstance);
		APIReturnData apiReturnData = new APIReturnData();
		apiReturnData.success();
		apiReturnData.putData("total", indexes.size());
		apiReturnData.putData("tableList", indexes);
		return apiReturnData;
	}

	@DeleteMapping("/remove/{id}")
	public APIReturnData remove(@PathVariable Long id) {
		indexService.delete(id);
		APIReturnData apiReturnData = new APIReturnData();
		apiReturnData.success("删除成功");
		return apiReturnData;
	}

	@PostMapping("/add")
	public APIReturnData add(@Validated @RequestBody ObjNodeTypeEvaluation indexobj) {
		indexService.insert(indexobj);
		APIReturnData apiReturnData = new APIReturnData();
		apiReturnData.success("添加成功");
		apiReturnData.putData("object", indexobj);
		return apiReturnData;
	}

	@PutMapping("/edit")
	public APIReturnData edit(@Validated @RequestBody ObjNodeTypeEvaluation indexobj) {
		indexService.update(indexobj);
		APIReturnData apiReturnData = new APIReturnData();
		apiReturnData.success("修改成功");
		return apiReturnData;
	}
}