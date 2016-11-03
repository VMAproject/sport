package com.sport.mvc.Controllers.smoll_fintess;


import com.sport.mvc.models.CategoryGroup;
import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;
import com.sport.mvc.services.CategoryGroupService;
import com.sport.mvc.services.GroupService;
import com.sport.mvc.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
@RequestMapping(value = "/group/")
public class A_GroupController {

    @Autowired
    @Qualifier("groupService")
    private GroupService groupService;

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;

    @Autowired
    @Qualifier("categoryGroupService")
    private CategoryGroupService categoryService;


//variable for taking the group id, when some group will by in use.
    private  Long idGroup;



    @RequestMapping(value = "/ShowGroupPage", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView();
     //create list student and group for add data to the jsp page
        List<CategoryGroup> categoryGroupList = categoryService.getAll();
        List<Group> groupsList = groupService.getAll();
       // List<Student> studentsList=studentService.getAll();

        List<Student> studentsList = new ArrayList<>();


//check in which a group of students
        for (Student s: studentService.getAll()){
            if( s.getGroupSort()!=null && s.getGroupSort().equals(groupService.getGroup(idGroup).getName()) ||
                    s.getGroupSort()!=null &&s.getGroupSort().equals(groupService.getGroup(idGroup).getNameTraine())){
                studentsList.add(s);
            }
        }
// show student in his group if group has more then 0 student
        if (!(studentsList.isEmpty())){
            modelAndView.addObject("studentList", studentsList);
        }

        modelAndView.addObject("studentList", studentsList);
        modelAndView.addObject("groupsList", groupsList);
        modelAndView.addObject("categoryList",categoryGroupList);
        //param for identifying locations is ->String chooseGroup
        if(idGroup!=null) {
            String chooseGroup = groupService.getGroup(idGroup).getName();
            modelAndView.addObject("chooseNewGroup", chooseGroup);
        }

        if(idGroup!=null) {
            String chooseNewGroupTrainer = groupService.getGroup(idGroup).getNameTraine();
            modelAndView.addObject("chooseNewGroupTrainer", chooseNewGroupTrainer);
        }

        //add to page model list of day in current month from method List<String> ListOfDayInMonth()
        modelAndView.addObject("listOfMonth", ListOfDayInMonth());
        modelAndView.setViewName("A_small_fitness_group");
        return modelAndView;
        //

    }

    @RequestMapping( value = "/AddGroupToInstructorsForm", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView  FormForAddInstructors() {
        // create model attribute to bind form data
        Group group = new Group();
        List<CategoryGroup> categoryGroupList = categoryService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList" ,categoryGroupList);
        modelAndView.addObject("group", group);
        modelAndView.setViewName("a_small_fitness/add_form/A_small_fitness_add_group_to_instructors");
        //  return "A_small_fitness_add_group";
        return  modelAndView;
    }


    @PostMapping("/saveGroupToTrainers")
    public String saveGroupToTrainers(@ModelAttribute("group") Group group,@RequestParam("choose") String categoryName) {
        //add group to DB
        if(categoryName.equals("")){
            groupService.addGroup(group);
        }else {
            CategoryGroup categoryGroup = new CategoryGroup();
            categoryGroup.setNameTraine(categoryName);
            for (CategoryGroup category: categoryService.getAll()) {
                if(category.getNameTraine()==null){
                    continue;
                }

                if (category.getNameTraine().equals(categoryGroup.getNameTraine())) {
                    group.setCategoryGroup(category);
                    groupService.addGroup(group);
                    break;
                }
            }
        }
        return "redirect:/group/AddGroupToInstructorsForm";
    }

    @RequestMapping( value = "/showFormForAddGroup", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView  FormForAddGroup() {
        // create model attribute to bind form data
        Group group = new Group();
        List<CategoryGroup> categoryGroupList = categoryService.getAll();
        List<String> stringList = new ArrayList<>();
        for(CategoryGroup category: categoryGroupList){
            stringList.add(category.getName());
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList" ,categoryGroupList);
        modelAndView.addObject("group", group);
        modelAndView.setViewName("a_small_fitness/add_form/A_small_fitness_add_group");
      //  return "A_small_fitness_add_group";
        return  modelAndView;
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group,@RequestParam("option") String categoryName) {
        //add group to DB


       if(categoryName.equals("")){
           groupService.addGroup(group);
       }
       else {
           CategoryGroup categoryGroup = new CategoryGroup();
           categoryGroup.setName(categoryName);
           for (CategoryGroup category : categoryService.getAll()) {
               if(category.getName()==null){
                   continue;
               }
               if (category.getName().equals(categoryGroup.getName())) {
                   group.setCategoryGroup(category);
                   groupService.addGroup(group);
                   break;
               }
           }
       }
        return "redirect:/group/showFormForAddGroup";
    }

    @RequestMapping("/showFormForAddCategory")
    public String showFormForAddCategory(Model theModel) {
        // create model attribute to bind form data
        CategoryGroup category = new CategoryGroup();
        theModel.addAttribute("category", category);
        return "a_small_fitness/add_form/A_small_fitness_add_category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("category") CategoryGroup category) {
        //add group to DB
        categoryService.addCategoryGroup(category);
        return "redirect:/group/showFormForAddCategory";
    }


    @RequestMapping("/showFormForAddCategoryTrainers")
    public String showFormForAddCategoryTrainers(Model theModel) {
        // create model attribute to bind form data
        CategoryGroup category = new CategoryGroup();
        theModel.addAttribute("category", category);
        return "a_small_fitness/add_form/A_small_fitness_add_category_trainers";
    }


    @PostMapping("/saveTrainersCategory")
    public String saveTrainersCategory(@ModelAttribute("category") CategoryGroup category) {
        //add group to DB
        categoryService.addCategoryGroup(category);
        return "redirect:/group/showFormForAddCategoryTrainers";
    }




    @RequestMapping( value = "/showFormForUpdate", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView  FormForUpdateGroups() {
        // create model attribute to bind form data
        Group group = new Group();
        List<Group> groupList = groupService.getAll();
       ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("groupList" ,groupList);
        modelAndView.addObject("group", group);
        modelAndView.setViewName("a_small_fitness/update_form/A_small_fitness_update_groups");
        //  return "A_small_fitness_add_group";
        return  modelAndView;
    }




    @PostMapping("/updateGroup")
    public String updateGroup(@ModelAttribute("group") Group group,@RequestParam("option") Long theId) {
        //add group to DB
        System.out.println(group.getName());
      for(Group g: groupService.getAll()){
          if(g.getId()==theId&& groupService.getGroup(theId).getName()!=null){
              g.setName(group.getName());
              groupService.addGroup(g);
              continue;
          }
          if(g.getId()==theId&& groupService.getGroup(theId).getNameTraine()!=null){
              g.setNameTraine(group.getName());
              groupService.addGroup(g);
              continue;
          }
      }
        return "redirect:/group/showFormForUpdate";
    }


    @RequestMapping( value = "/showFormForUpdateCategory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView  FormForUpdateTrainersGroups() {
        // create model attribute to bind form data
        CategoryGroup category = new CategoryGroup();

        List<CategoryGroup> categoryGroupList = categoryService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList" ,categoryGroupList);
        modelAndView.addObject("category", category);
        modelAndView.setViewName("a_small_fitness/update_form/A_small_fitness_update_category");
        //  return "A_small_fitness_add_group";
        return  modelAndView;
    }




    @PostMapping("/updateCategory")
    public String updateTrainersGroup(@ModelAttribute("category") CategoryGroup category,@RequestParam("option") Long theId) {
        //add group to DB

        for(CategoryGroup c: categoryService.getAll()){
            if(c.getId()==theId && categoryService.getCategoryGroup(theId).getNameTraine()!=null) {
                c.setNameTraine(category.getName());
                categoryService.addCategoryGroup(c);
            }
            if(c.getId()==theId && categoryService.getCategoryGroup(theId).getName()!=null) {
                c.setName(category.getName());
                categoryService.addCategoryGroup(c);
            }
        }
        return "redirect:/group/showFormForUpdateCategory";
    }



    @RequestMapping("/deleteGroup")
    public  void deleteGrout(){
      //  groupService.deleteListOfGroup();
    }

    @RequestMapping("/addStudentToGroupForm")
    public  String addStudentToGroup(Model theModel){
        //create new student for add form
        Student theStudent = new Student();
        //transfer student to "A_add_to_group_Student" form
        theModel.addAttribute("student", theStudent);
        return "a_small_fitness/add_form/A_add_to_group_Student";
    }



    @RequestMapping("saveStudentToGroup")
    public  String saveStudentToGroup(@ModelAttribute("student") Student theStudent){

//        Set<Group> groupSet = new HashSet<>();
//        groupSet.add(groupService.getGroup(idGroup));
//        theStudent.setGroups(groupSet);
//        return "redirect:/group/addStudentToGroupForm";


//SECOND METHODp
        String theGroup;
        if (groupService.getGroup(idGroup).getNameTraine()==null) {
            theGroup = groupService.getGroup(idGroup).getName();
        }
        else {
            theGroup =groupService.getGroup(idGroup).getNameTraine();
        }
        theStudent.setGroupSort(theGroup);
     studentService.addStudent(theStudent);
        return "redirect:/group/addStudentToGroupForm";

    }

    @RequestMapping("/takeIdGroup")
    public String TakeIdGroup(@RequestParam("groupId") long theId ) {
        //take id group, where we now, and write it in to global variable->idGroup
        idGroup = theId;
        //return to showGroup page for fow all data on the  page
        return "redirect:/group/ShowGroupPage";
    }

//    @RequestMapping("/takeIdCategory")
//    public String TakeIdCategory(@RequestParam("categoryId") long theId ) {
//        //take id group, where we now, and write it in to global variable->idGroup
//        idCategory = theId;
//        //return to showGroup page for fow all data on the  page
//        return "redirect:/group/ShowGroupPage";
//    }

    private List<String> ListOfDayInMonth() {
        Calendar calendar = Calendar.getInstance();
        int iYear = calendar.get(Calendar.YEAR);
        int iMonth = calendar.get(Calendar.MONTH);
        int iDay = 1;
// Create a calendar object and set year and month
        Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);
// Get the number of days in that month
        List<String> listDayOfMonth = new ArrayList<>();
        String curentDate = null;
        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= daysInMonth; i++) {
            curentDate = i + "." + iMonth + "." + iYear;
            listDayOfMonth.add(curentDate);

        }
        return listDayOfMonth;
    }

}

